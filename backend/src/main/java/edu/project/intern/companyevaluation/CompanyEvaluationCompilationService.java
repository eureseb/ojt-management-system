package edu.project.intern.companyevaluation;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyEvaluationCompilationService {
  private CompanyEvaluationRepository companyEvaluationRepository;

  public List<String> getReasonsForRecommending(Long companyId){
    return companyEvaluationRepository.findReasonsForRecommending(companyId);
  }

  public List<String> getExperiencesWithCompany(Long companyId){
    return companyEvaluationRepository.findExperiencesWithCompany(companyId);
  }
}
