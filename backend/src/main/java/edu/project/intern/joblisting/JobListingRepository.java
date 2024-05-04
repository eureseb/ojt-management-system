package edu.project.intern.joblisting;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Long>{
	@Query("SELECT j FROM JobListing j ORDER BY CASE WHEN j.company.id IN (?1) THEN 0 ELSE 1 END, j.company.ranking")
	Page<JobListing> findAllPrioritizeSuggested(List<Long> suggestedCompanyIds, Pageable pageable);
}
