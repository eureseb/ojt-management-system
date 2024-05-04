package edu.project.intern.student;

import java.util.List;

public record SuggestedCompanyResponse(
				Long companyID,
				List<Long> companyIDs
) { }
