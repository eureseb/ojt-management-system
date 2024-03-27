package edu.project.intern.joblisting;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-listings")
@AllArgsConstructor
public class JobListingController {
  private JobListingService jobListingService;

  @GetMapping
  public Page<JobListing> getJobListings(Pageable pageable) {
    return jobListingService.getJobListings(pageable);
  }
}
