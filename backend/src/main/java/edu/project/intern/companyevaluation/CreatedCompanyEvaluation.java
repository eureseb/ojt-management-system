package edu.project.intern.companyevaluation;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedCompanyEvaluation extends ApplicationEvent {
  private final CompanyEvaluation companyEvaluationCreated;
  public CreatedCompanyEvaluation(Object source, CompanyEvaluation companyEvaluation) {
    super(source);
    this.companyEvaluationCreated = companyEvaluation;
  }
}
