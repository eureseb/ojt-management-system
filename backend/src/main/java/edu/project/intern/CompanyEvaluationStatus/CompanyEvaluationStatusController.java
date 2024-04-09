package edu.project.intern.CompanyEvaluationStatus;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-evaluation-status")
@AllArgsConstructor
public class CompanyEvaluationStatusController {
  private CompanyEvaluationStatusService companyEvaluationStatusService;

  @PutMapping
  @PreAuthorize("hasRole('TEACHER')")
  public void updateCompanyEvaluationStatus(@RequestBody CompanyEvaluationStatus companyEvaluationStatus) {
    companyEvaluationStatusService.updateCompanyEvaluationStatus(companyEvaluationStatus);
  }

  @GetMapping
  public CompanyEvaluationStatus getCompanyEvaluationStatus() {
    return companyEvaluationStatusService.getCompanyEvaluationStatus();
  }
}
