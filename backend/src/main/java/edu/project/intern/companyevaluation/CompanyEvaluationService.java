package edu.project.intern.companyevaluation;

import edu.project.intern.company.CompanyService;
import edu.project.intern.student.StudentService;
import edu.project.intern.user.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyEvaluationService {
  private CompanyEvaluationRepository companyEvaluationRepository;
  private StudentService studentService;
  private CompanyService companyService;

  public CompanyEvaluation createCompanyEvaluation(CompanyEvaluationRequest companyEvaluationRequest, User evaluator) {
    var student = studentService.getStudentByUser(evaluator);
    var company = companyService.getCompanyById(companyEvaluationRequest.companyId());
    var companyEvaluation = CompanyEvaluation.builder()
                                .evaluatedBy(student)
                                .company(company)
                                .dateEvaluated(LocalDateTime.now())
                                .evaluationTerm(companyEvaluationRequest.evaluationTerm())
                                .experienceEvaluation(companyEvaluationRequest.experienceEvaluation())
                                .experienceWithCompany(companyEvaluationRequest.experienceWithCompany())
                                .isRecommendedForOJT(companyEvaluationRequest.isRecommendedForOJT())
                                .isRecommendedForOJTReason(companyEvaluationRequest.isRecommendedForOJTReason())
                                .build();
    return companyEvaluationRepository.save(companyEvaluation);
  }

  public Page<CompanyEvaluation> getCompanyEvaluations(Long companyId, Pageable pageable) {
    return companyEvaluationRepository.findByCompanyId(companyId, pageable);
  }
}
