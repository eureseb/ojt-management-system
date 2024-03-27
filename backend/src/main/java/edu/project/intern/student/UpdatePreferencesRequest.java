package edu.project.intern.student;

public record UpdatePreferencesRequest (
    String companyPreferences,
    String workEnvironmentPreferences,
    String locationAndCommutePreferences,
    String compensationAndBenefitsPreferences,
    String technicalSkillsAndInterests,
    String feedbackAndSuggestions
) {}
