package edu.project.intern.joblisting;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobListingService {
  private JobListingRepository jobListingRepository;

  public Page<JobListing> getJobListings(Pageable pageable) {
    return jobListingRepository.findAll(pageable);
  }
  public JobListing getJobListingById(Long id) {
    return jobListingRepository.findById(id).orElseThrow(() -> new RuntimeException("Job Listing with id" + id + " not found"));
  }
}
