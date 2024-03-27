package edu.project.intern.companyevaluation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEvaluationRepository extends JpaRepository<CompanyEvaluation, Long>{
  Page<CompanyEvaluation> findByCompanyId(Long companyId, Pageable pageable);
}
