package edu.project.intern.student;

import edu.project.intern.company.Company;
import edu.project.intern.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.List;
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
  private List<String> companyPreferences;
  private String workEnvironmentPreferences;
  @Column(columnDefinition = "TEXT")
  private String locationAndCommutePreferences;
  @Column(columnDefinition = "TEXT")
  private String compensationAndBenefitsPreferences;
  @Column(columnDefinition = "TEXT")
  private String technicalSkillsAndInterests;
  @Column(columnDefinition = "TEXT")
  private String feedbackAndSuggestions;
  @ManyToOne
  private Company currentCompany;
}
