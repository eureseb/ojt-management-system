from .company import Company
import requests

class CompanyService:
    def __init__(self):
        # Dummy data for demonstration
        self.companies = [
            Company(
                companyID=1,
                name="Company A",
                tags=["ProfessionalEnvironment", "NewKnowledge", "Selflearning",
                      "IndustryExperience", "PleasantExperience", "GreatExperience",
                      "GoodMentors", "SystemsDevelopment", "Allowance",
                      "PoorHandling", "UnpleasantExperience", "ChallengingExperience",
                      "WebDevelopment", "ProjectManagement", "GoodEnvironment"],
                rank=1,
            )
        ]

    def get_company_rankings(self):
        return self.companies

    def get_company_id_by_tags(self, tags):
        # Logic to retrieve company ID based on provided tags
        # For simplicity, let's assume it returns the company ID of the first company with matching tags
        for company in self.companies:
            if all(tag in company.tags for tag in tags):
                return company.companyID
        return None
    
    def get_company_evaluation_data(self, company_id):
        # Make a GET request to the Java endpoint to retrieve company evaluation data
        response = requests.get(f'http://localhost:8080/company-evaluations?companyId={company_id}')
        if response.status_code == 200:
            return response.json()
        else:
            # Handle error response
            return None
