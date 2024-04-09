package edu.project.intern.teacher;

public record TeacherSignUpRequest(
    String firstName,
    String lastName,
    String email,
    String password
) { }
