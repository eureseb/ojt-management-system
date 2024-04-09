package edu.project.intern.companyevaluation;

import edu.project.intern.company.Company;
import edu.project.intern.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

public record CompanyEvaluationDTO (
    Long id,
    Long companyId,
    Boolean isRecommendedForOJT,
    String isRecommendedForOJTReason,
    ExperienceEvaluation experienceEvaluation,
    String experienceWithCompany,
    String evaluatedBy,
    LocalDateTime dateEvaluated
){}
