package edu.project.intern.jobapplication;

import edu.project.intern.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-applications")
@AllArgsConstructor
public class JobApplicationController {
  private JobApplicationService jobApplicationService;
  @PostMapping
  @PreAuthorize("hasRole('STUDENT')")
  public JobApplication applyForJob(@RequestBody JobApplicationDTO jobApplicationDTO) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    var user = (User) authentication.getPrincipal();
    return jobApplicationService.applyForJob(jobApplicationDTO, user);
  }

  @GetMapping
  @PreAuthorize("hasRole('TEACHER')")
  public Page<JobApplication> getApplications(Pageable pageable) {
    return jobApplicationService.getApplications(pageable);
  }

  @PatchMapping("/{id}/status")
  @PreAuthorize("hasRole('TEACHER')")
  public JobApplication updateStatus(@PathVariable Long id, @RequestParam JobApplicationStatus status) {
    return jobApplicationService.updateStatus(id, status);
  }
}
