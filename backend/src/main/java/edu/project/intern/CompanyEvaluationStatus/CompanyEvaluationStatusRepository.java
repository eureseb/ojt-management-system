package edu.project.intern.CompanyEvaluationStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEvaluationStatusRepository extends JpaRepository<CompanyEvaluationStatus, Long> {
}
