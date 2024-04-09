package edu.project.intern.company;

public record UpdateCompanyRequest (
    String name,
    String description,
    String contactEmail,
    String addressLine1,
    String addressLine2
){}
