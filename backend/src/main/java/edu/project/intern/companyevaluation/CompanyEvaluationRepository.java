package edu.project.intern.companyevaluation;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEvaluationRepository extends JpaRepository<CompanyEvaluation, Long>{
  Page<CompanyEvaluation> findByCompanyId(Long companyId, Pageable pageable);

  @Query("SELECT c.isRecommendedForOJTReason FROM CompanyEvaluation c WHERE c.company.id = :companyId")
  List<String> findReasonsForRecommending(Long companyId);

  @Query("SELECT c.experienceWithCompany FROM CompanyEvaluation c WHERE c.company.id = :companyId")
  List<String> findExperiencesWithCompany(Long companyId);
}
