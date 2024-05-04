package edu.project.intern.company;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import edu.project.intern.companyevaluation.CompanyEvaluationCompilationService;
import edu.project.intern.companyevaluation.CreatedCompanyEvaluation;
import edu.project.intern.tracker.Tracker;
import edu.project.intern.tracker.TrackerRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CompanyService {
	private final Logger logger = LoggerFactory.getLogger(CompanyService.class);
	private CompanyRepository companyRepository;
	private OpenAiService openAiService;
	private CompanyEvaluationCompilationService companyEvaluationCompilationService;
	private TrackerRepository trackerRepository;
	private String aIServiceUrl;

	public CompanyService(@Value("${aiservice.url}") String aiServiceUrl,
					CompanyRepository companyRepository, OpenAiService openAiService,
					CompanyEvaluationCompilationService companyEvaluationCompilationService,
					TrackerRepository trackerRepository) {
		this.companyRepository = companyRepository;
		this.openAiService = openAiService;
		this.companyEvaluationCompilationService = companyEvaluationCompilationService;
		this.trackerRepository = trackerRepository;
		this.aIServiceUrl = aiServiceUrl;
	}

	public Page<Company> getCompanies(Pageable pageable) {
		return companyRepository.findAll(pageable);
	}

	public List<CompactCompany> getAllCompanies() {
		return companyRepository.findAllCompact();
	}

	public Company getCompanyById(Long id) {
		return companyRepository.findById(id)
													.orElseThrow(() -> new CompanyNotFoundException("Company not found with id " + id));
	}

	@Transactional
	@EventListener(CreatedCompanyEvaluation.class)
	public void onCompanyEvaluationCreated(CreatedCompanyEvaluation event) {
		var company = event.getCompanyEvaluationCreated().getCompany();
		if (company.getVeryBadExperienceCount() == null) {
			company.setVeryBadExperienceCount(0L);
		}
		if (company.getBadExperienceCount() == null) {
			company.setBadExperienceCount(0L);
		}
		if (company.getGoodExperienceCount() == null) {
			company.setGoodExperienceCount(0L);
		}
		if (company.getVeryGoodExperienceCount() == null) {
			company.setVeryGoodExperienceCount(0L);
		}
		if (company.getIsRecommendedForOJTCount() == null) {
			company.setIsRecommendedForOJTCount(0L);
		}
		if (company.getIsNotRecommendedForOJTCount() == null) {
			company.setIsNotRecommendedForOJTCount(0L);
		}
		if (company.getReviewCount() == null) {
			company.setReviewCount(0L);
		}
		switch (event.getCompanyEvaluationCreated().getExperienceEvaluation()) {
			case VERY_BAD:
				company.setVeryBadExperienceCount(company.getVeryBadExperienceCount() + 1);
				break;
			case BAD:
				company.setBadExperienceCount(company.getBadExperienceCount() + 1);
				break;
			case GOOD:
				company.setGoodExperienceCount(company.getGoodExperienceCount() + 1);
				break;
			case VERY_GOOD:
				company.setVeryGoodExperienceCount(company.getVeryGoodExperienceCount() + 1);
				break;
		}
		if (event.getCompanyEvaluationCreated().getIsRecommendedForOJT()) {
			company.setIsRecommendedForOJTCount(company.getIsRecommendedForOJTCount() + 1);
		} else {
			company.setIsNotRecommendedForOJTCount(company.getIsNotRecommendedForOJTCount() + 1);
		}
		company.setReviewCount(company.getReviewCount() + 1);
		if (company.getReviewCount() % 5 == 0 && company.getReviewCount() > 0) {
			Thread thread = new Thread(() -> {
				logger.info("Generating review summary");
				String reviewSummary = company.getReviewSummary();
				try {
					reviewSummary = "generateCompanyReviewSummary(company)";
					logger.info("Successfully generated review summary");
				} catch (Exception e) {
					logger.info("Unable to generate review summary");
				}
				var updatedCompany = companyRepository.findById(company.getId()).orElseThrow(
								() -> new CompanyNotFoundException("Company not found with id " + company.getId()));
				updatedCompany.setReviewSummary(reviewSummary);
				companyRepository.save(updatedCompany);
			});
			thread.start();
		}
		Tracker evaluationCountTracker =
						trackerRepository.findById("evaluationCount").orElse(new Tracker("evaluationCount", "0"));
		evaluationCountTracker.setValue(
						String.valueOf(Long.parseLong(evaluationCountTracker.getValue()) + 1));
		trackerRepository.save(evaluationCountTracker);
		if (Long.parseLong(evaluationCountTracker.getValue()) % 5 == 0) {
			logger.info(
							"Refreshing company ranking on evaluation count: " + evaluationCountTracker.getValue());
			refreshCompanyRanking();
		}
		companyRepository.save(company);
	}

	public String generateCompanyReviewSummary(Company company) {
		List<String> reasonsForRecommending =
						companyEvaluationCompilationService.getReasonsForRecommending(company.getId());
		List<String> experiencesWithCompany =
						companyEvaluationCompilationService.getExperiencesWithCompany(company.getId());
		List<ChatMessage> messages = new ArrayList<>();
		ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), """
						Given reviews for a company, create a summary of all the reviews with the following categories. Each category should be answered in 1-2 sentences. The final summary should be 1 paragraph long and should be a guide for future employees to decide if they want to join the company being reviewed.
						Structure your response in json format like this.     
						{
						  companyCulture:  ...,
						  opportunitiesForGrowth: ...,
						  workLifeBalance:  ...,
						  compensationAndBenefits:  ...,
						  leadershipAndManagement:  ...,
						  innovationAndAdaptability:  ...,
						  finalSummary:  should be 1 paragraph long
						}
						""");
		messages.add(systemMessage);
		ChatMessage userMessage1 = new ChatMessage(ChatMessageRole.USER.value(),
						"Here are the reasons for recommending/not recommending the company: " +
										reasonsForRecommending.stream().map(Object::toString).collect(Collectors.joining("; ")));
		messages.add(userMessage1);
		ChatMessage userMessage2 = new ChatMessage(ChatMessageRole.USER.value(),
						"Here are the individual experiences with the company: " +
										experiencesWithCompany.stream().map(Object::toString).collect(Collectors.joining("; ")));
		messages.add(userMessage2);
		ChatCompletionRequest request =
						ChatCompletionRequest.builder().messages(messages).model("gpt-3.5-turbo").build();
		var response =
						openAiService.createChatCompletion(request).getChoices().get(0).getMessage().getContent();
		JSONObject jsonObject = new JSONObject(response);
		return jsonObject.getString("finalSummary");
	}

	public Company updateCompany(Long id, UpdateCompanyRequest request) {
		Company company = companyRepository.findById(id).orElseThrow(
						() -> new CompanyNotFoundException("Company not found with id " + id));
		company.setName(request.name());
		company.setDescription(request.description());
		company.setAddressLine1(request.addressLine1());
		company.setAddressLine2(request.addressLine2());
		company.setContactEmail(request.contactEmail());
		return companyRepository.save(company);
	}

	public Company createCompany(CreateCompanyRequest request) {
		return companyRepository.save(
						Company.builder().name(request.name()).description(request.description())
										.addressLine1(request.addressLine1()).addressLine2(request.addressLine2())
										.contactEmail(request.contactEmail()).build());
	}

	public boolean refreshCompanyRanking() {
		RestClient client = RestClient.create();
		List<CompanyRankingResponse> companyRankings = null;
		try {
			companyRankings = client.get().uri(aIServiceUrl + "/api/companyranking").retrieve()
																									.body(new ParameterizedTypeReference<>() {
																									});
		} catch (Exception e) {
			logger.error("Error in refreshing company rankings", e);
			return false;
		}
		if (companyRankings == null || companyRankings.isEmpty()) {
			logger.info("No company rankings found");
			return false;
		}
		companyRankings.forEach(companyRanking -> {
			Company company = companyRepository.findById(companyRanking.companyID()).orElseThrow(
							() -> new CompanyNotFoundException(
											"Company not found with id " + companyRanking.companyID()));
			company.setTags(companyRanking.tags());
			company.setRanking(companyRanking.rank());
			companyRepository.save(company);
		});
		System.out.println(companyRankings);
		logger.info("Successfully refreshed company rankings");
		return true;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean shouldNotRepeat = false;
		while (!shouldNotRepeat) {
			shouldNotRepeat = refreshCompanyRanking();
			if (shouldNotRepeat) {
				break;
			}
			try {
				logger.info("Waiting for 5 seconds before retrying");
				Thread.sleep(5000);
				logger.info("Retrying to refresh company rankings");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
