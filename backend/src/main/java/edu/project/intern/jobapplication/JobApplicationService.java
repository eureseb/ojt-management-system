package edu.project.intern.jobapplication;

import edu.project.intern.joblisting.JobListing;
import edu.project.intern.joblisting.JobListingService;
import edu.project.intern.student.Student;
import edu.project.intern.student.StudentService;
import edu.project.intern.user.User;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobApplicationService {
  private StudentService studentService;
  private JobListingService jobListingService;
  private JobApplicationRepository jobApplicationRepository;
  private ApplicationEventPublisher applicationEventPublisher;

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
                                        .status(JobApplicationStatus.PENDING)
                                        .build();
    return jobApplicationRepository.save(jobApplication);
  }

  public Page<JobApplication> getApplications(Pageable pageable) {
    return jobApplicationRepository.findAllPending(pageable);
  }

  @Transactional
  public JobApplication updateStatus(Long id, JobApplicationStatus status) {
    if(status == JobApplicationStatus.PENDING) throw new IllegalArgumentException("Cannot set status to PENDING");
    JobApplication jobApplication = jobApplicationRepository.findById(id)
                                        .orElseThrow(() -> new IllegalArgumentException("Job application not found"));
    jobApplication.setStatus(status);
    if(status == JobApplicationStatus.ACCEPTED){
      jobApplicationRepository.updateStatusByStudentExcluding(JobApplicationStatus.REJECTED, jobApplication.getStudent(), jobApplication.getId());
      applicationEventPublisher.publishEvent(new AcceptedJobApplication(this, jobApplication));
    }
    return jobApplicationRepository.save(jobApplication);
  }
}
