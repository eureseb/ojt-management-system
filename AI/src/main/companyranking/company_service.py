from .company import Company

class CompanyService:
    def __init__(self):
        # Dummy data for demonstration
        self.companies = [
            Company(
                companyID=1,
                name="Company A",
                tags={
                    "ProfessionalEnvironment": 26.47,
                    "NewKnowledge": 76.46,
                    "Selflearning": 49.24,
                    "IndustryExperience": 100.00,
                    "PleasantExperience": 92.61,
                    "GreatExperience": 49.68,
                    "GoodMentors": 95.11,
                    "SystemsDevelopment": 41.72,
                    "Allowance": 0.00,
                    "PoorHandling": 7.18,
                    "UnpleasantExperience": 3.95,
                    "ChallengingExperience": 28.54,
                    "WebDevelopment": 20.85,
                    "ProjectManagement": 25.64,
                    "GoodEnvironment": 27.34
                },
                rank=1
            )
        ]

    def get_company_rankings(self):
        return self.companies
