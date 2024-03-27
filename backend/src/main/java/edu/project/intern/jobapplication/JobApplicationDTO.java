package edu.project.intern.jobapplication;

import java.time.LocalDateTime;

public record JobApplicationDTO (
    Long jobListingId,
    String coverLetterRecipientEmail,
    String coverLetterSubject,
    String coverLetterBody
){}
