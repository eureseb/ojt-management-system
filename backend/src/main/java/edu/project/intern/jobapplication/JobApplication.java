package edu.project.intern.jobapplication;

import edu.project.intern.joblisting.JobListing;
import edu.project.intern.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobApplication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Student student;
  @ManyToOne
  private JobListing jobListing;
  private String coverLetterRecipientEmail;
  private String coverLetterSubject;
  @Column(columnDefinition = "TEXT")
  private String coverLetterBody;
  private String resumeFileUrl;
  private LocalDateTime dateApplied;
}
