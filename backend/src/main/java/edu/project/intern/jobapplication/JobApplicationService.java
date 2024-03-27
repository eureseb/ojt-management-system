package edu.project.intern.jobapplication;

import edu.project.intern.joblisting.JobListing;
import edu.project.intern.joblisting.JobListingService;
import edu.project.intern.student.Student;
import edu.project.intern.student.StudentService;
import edu.project.intern.user.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobApplicationService {
  private StudentService studentService;
  private JobListingService jobListingService;
  private JobApplicationRepository jobApplicationRepository;
  public JobApplication applyForJob(JobApplicationDTO jobApplicationDTO, User user) {
    Student student = studentService.getStudentByUser(user);
    JobListing jobListing = jobListingService.getJobListingById(jobApplicationDTO.jobListingId());
    JobApplication jobApplication = JobApplication.builder()
                                        .student(student)
                                        .jobListing(jobListing)
                                        .dateApplied(LocalDateTime.now())
                                        .coverLetterRecipientEmail(jobApplicationDTO.coverLetterRecipientEmail())
                                        .coverLetterSubject(jobApplicationDTO.coverLetterSubject())
                                        .coverLetterBody(jobApplicationDTO.coverLetterBody())
                                        .build();
    return jobApplicationRepository.save(jobApplication);
  }
}
