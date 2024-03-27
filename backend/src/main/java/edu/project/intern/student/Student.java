package edu.project.intern.student;

import edu.project.intern.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private User accountInformation;
  @Column(columnDefinition = "TEXT")
  private String companyPreferences;
  @Column(columnDefinition = "TEXT")
  private String workEnvironmentPreferences;
  @Column(columnDefinition = "TEXT")
  private String locationAndCommutePreferences;
  @Column(columnDefinition = "TEXT")
  private String compensationAndBenefitsPreferences;
  @Column(columnDefinition = "TEXT")
  private String technicalSkillsAndInterests;
  @Column(columnDefinition = "TEXT")
  private String feedbackAndSuggestions;
}
