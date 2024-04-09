package edu.project.intern.student;

import java.util.List;

public record UpdatePreferencesRequest (
    List<String> companyPreferences,
    String workEnvironmentPreferences,
    String locationAndCommutePreferences,
    String compensationAndBenefitsPreferences,
    String technicalSkillsAndInterests,
    String feedbackAndSuggestions
) {}
