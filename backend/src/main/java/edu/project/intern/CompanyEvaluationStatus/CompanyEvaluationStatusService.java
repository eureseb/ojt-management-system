package edu.project.intern.CompanyEvaluationStatus;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyEvaluationStatusService {
  private CompanyEvaluationStatusRepository companyEvaluationStatusRepository;
  public void updateCompanyEvaluationStatus(CompanyEvaluationStatus companyEvaluationStatusUpdate) {
    CompanyEvaluationStatus companyEvaluationStatus = companyEvaluationStatusRepository.findById(1L).orElseThrow();
    companyEvaluationStatus.setIsEnabled(companyEvaluationStatusUpdate.getIsEnabled());
    companyEvaluationStatus.setTitle(companyEvaluationStatusUpdate.getTitle());
    companyEvaluationStatus.setDueDate(companyEvaluationStatusUpdate.getDueDate());
    companyEvaluationStatusRepository.save(companyEvaluationStatus);
  }

  public CompanyEvaluationStatus getCompanyEvaluationStatus() {
    CompanyEvaluationStatus companyEvaluationStatus = companyEvaluationStatusRepository.findById(1L).orElseThrow();
    return companyEvaluationStatus;
  }
}
