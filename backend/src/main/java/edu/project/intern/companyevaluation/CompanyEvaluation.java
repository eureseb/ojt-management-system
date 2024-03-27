package edu.project.intern.companyevaluation;

import edu.project.intern.company.Company;
import edu.project.intern.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class CompanyEvaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Company company;
  private Boolean isRecommendedForOJT;
  @Column(columnDefinition = "TEXT")
  private String isRecommendedForOJTReason;
  @Enumerated(EnumType.STRING)
  private ExperienceEvaluation experienceEvaluation;
  @Enumerated(EnumType.STRING)
  private EvaluationTerm evaluationTerm;
  @Column(columnDefinition = "TEXT")
  private String experienceWithCompany;
  @ManyToOne
  private Student evaluatedBy;
  private LocalDateTime dateEvaluated;
}
