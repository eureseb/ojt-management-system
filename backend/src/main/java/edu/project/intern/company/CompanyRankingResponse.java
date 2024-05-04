package edu.project.intern.company;

import java.util.List;

public record CompanyRankingResponse (
				Long companyID,
				List<String> experience_evaluation,
				Integer rank,
				List<String> tags
){}
