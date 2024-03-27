package edu.project.intern.jobapplication;

import edu.project.intern.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-applications")
@AllArgsConstructor
public class JobApplicationController {
  private JobApplicationService jobApplicationService;
  @PostMapping
  public JobApplication applyForJob(@RequestBody JobApplicationDTO jobApplicationDTO) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    var user = (User) authentication.getPrincipal();
    return jobApplicationService.applyForJob(jobApplicationDTO, user);
  }
}
