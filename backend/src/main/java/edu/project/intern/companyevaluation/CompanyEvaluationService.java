package edu.project.intern.companyevaluation;

import edu.project.intern.CompanyEvaluationStatus.CompanyEvaluationStatusService;
import edu.project.intern.company.CompanyService;
import edu.project.intern.student.StudentService;
import edu.project.intern.user.User;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyEvaluationService {
  private CompanyEvaluationRepository companyEvaluationRepository;
  private StudentService studentService;
  private CompanyService companyService;
  private ApplicationEventPublisher applicationEventPublisher;
  private CompanyEvaluationStatusService companyEvaluationStatusService;

  public CompanyEvaluation createCompanyEvaluation(CompanyEvaluationRequest companyEvaluationRequest, User evaluator) {
    var companyEvaluationStatus = companyEvaluationStatusService.getCompanyEvaluationStatus();
    if(!companyEvaluationStatus.getIsEnabled()) {
      throw new IllegalArgumentException("Company evaluation is disabled");
    }
    if(companyEvaluationStatus.getDueDate().isBefore(LocalDateTime.now())) {
      throw new IllegalArgumentException("Company evaluation is past due");
    }
    var student = studentService.getStudentByUser(evaluator);
    var company = companyService.getCompanyById(companyEvaluationRequest.companyId());
    var companyEvaluation = CompanyEvaluation.builder()
                                .evaluatedBy(student)
                                .company(company)
                                .dateEvaluated(LocalDateTime.now())
                                .experienceEvaluation(companyEvaluationRequest.experienceEvaluation())
                                .experienceWithCompany(companyEvaluationRequest.experienceWithCompany())
                                .isRecommendedForOJT(companyEvaluationRequest.isRecommendedForOJT())
                                .isRecommendedForOJTReason(companyEvaluationRequest.isRecommendedForOJTReason())
                                .build();
    companyEvaluation = companyEvaluationRepository.save(companyEvaluation);
    applicationEventPublisher.publishEvent(new CreatedCompanyEvaluation(this, companyEvaluation));
    return companyEvaluation;
  }

  public Page<CompanyEvaluationDTO> getCompanyEvaluations(Long companyId, Pageable pageable) {
    Page<CompanyEvaluation> companyEvaluations = companyEvaluationRepository.findByCompanyId(companyId, pageable);
    Page<CompanyEvaluationDTO> companyEvaluationDTOS = companyEvaluations.map(companyEvaluation -> new CompanyEvaluationDTO(
        companyEvaluation.getId(),
      companyEvaluation.getCompany().getId(),
      companyEvaluation.getIsRecommendedForOJT(),
      companyEvaluation.getIsRecommendedForOJTReason(),
      companyEvaluation.getExperienceEvaluation(),
      companyEvaluation.getExperienceWithCompany(),
      anonymizeName(companyEvaluation.getEvaluatedBy().getAccountInformation().getFirstName(), companyEvaluation.getEvaluatedBy().getAccountInformation().getLastName()),
      companyEvaluation.getDateEvaluated()
    ));
    return companyEvaluationDTOS;
  }

  private String anonymizeName(String firstName, String lastName) {
    StringBuilder sb = new StringBuilder("");
    sb.append(firstName.charAt(0));
    sb.append("*".repeat(Math.max(0, firstName.length() - 1)));
    sb.append(" ");
    sb.append(lastName.charAt(0));
    sb.append("*".repeat(Math.max(0, lastName.length() - 1)));
    return sb.toString();
  }
}
