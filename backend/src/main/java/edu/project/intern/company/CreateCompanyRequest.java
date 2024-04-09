package edu.project.intern.company;

public record CreateCompanyRequest(
    String name,
    String description,
    String contactEmail,
    String addressLine1,
    String addressLine2
) {}
