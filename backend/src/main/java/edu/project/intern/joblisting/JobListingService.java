package edu.project.intern.joblisting;

import edu.project.intern.student.Student;
import edu.project.intern.student.StudentService;
import edu.project.intern.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobListingService {
  private JobListingRepository jobListingRepository;
  private StudentService studentService;

  public Page<JobListing> getJobListings(Pageable pageable) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    var user = (User) authentication.getPrincipal();
    if(user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
      System.out.println("Hello world");
      Student student = studentService.getStudentByUser(user);
      return jobListingRepository.findAllPrioritizeSuggested(student.getSuggestedCompanyId(), pageable);
    }
    System.out.println(user.getAuthorities());
    return jobListingRepository.findAll(pageable);
  }
  public JobListing getJobListingById(Long id) {
    return jobListingRepository.findById(id).orElseThrow(() -> new RuntimeException("Job Listing with id" + id + " not found"));
  }
}
