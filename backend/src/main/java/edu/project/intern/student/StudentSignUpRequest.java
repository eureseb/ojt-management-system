package edu.project.intern.student;

public record StudentSignUpRequest (
    String firstName,
    String lastName,
    String email,
    String password
) { }
