from .company import Company
from db import get_db

class CompanyService:
    def __init__(self):
        self.populate_companies()

    def populate_companies(self):
        try:
            db = get_db()
            cursor = db.cursor()
            cursor.execute("SELECT * FROM company_evaluation")
            data = cursor.fetchall()
            self.companies = []
            for entry in data:
                company_id = entry[1]
                experience_evaluation = entry[5]
                # Create a Company object
                company = Company(
                    companyID=company_id,
                    experience_evaluation=experience_evaluation,
                    tags=[
                        "ProfessionalEnvironment", "NewKnowledge", "Selflearning",
                        "IndustryExperience", "PleasantExperience", "GreatExperience",
                        "GoodMentors", "SystemsDevelopment", "Allowance",
                        "PoorHandling", "UnpleasantExperience", "ChallengingExperience",
                        "WebDevelopment", "ProjectManagement", "GoodEnvironment"
                    ],
                    rank=1  # Placeholder value, you may update this based on evaluation status
                )
                self.companies.append(company)
        except Exception as e:
            # Handle any exceptions
            print(f"Failed to fetch company data from database: {e}")
            self.companies = []  # Set companies to an empty list to avoid potential issues

    def get_company_rankings(self):
        return self.companies

    def get_company_id_by_tags(self, tags):
        # Logic to retrieve company ID based on provided tags
        # For simplicity, let's assume it returns the company ID of the first company with matching tags
        for company in self.companies:
            if all(tag in company.tags for tag in tags):
                return company.companyID
        return None
