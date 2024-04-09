package edu.project.intern.companyevaluation;

public record CompanyEvaluationRequest(
    Long companyId,
    Boolean isRecommendedForOJT,
    String isRecommendedForOJTReason,
    ExperienceEvaluation experienceEvaluation,
    String experienceWithCompany
) {}
