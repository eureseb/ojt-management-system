package edu.project.intern.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
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
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private List<String> tags;
  @Column(columnDefinition = "TEXT")
  private String addressLine1;
  @Column(columnDefinition = "TEXT")
  private String addressLine2;
  private Integer yearEstablished;
  private Integer noOfEmployeesMin;
  private Integer noOfEmployeesMax;
  private String contactEmail;
  @Column(columnDefinition = "TEXT")
  private String description;
}
