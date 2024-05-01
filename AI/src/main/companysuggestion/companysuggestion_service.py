from ..companyranking.company_service import CompanyService

class CompanySuggestionService:
    def __init__(self):
        self.company_service = CompanyService()

    def get_company_id_by_tags(self, tags):
        # Logic to retrieve company ID based on provided tags
        # For simplicity, let's assume it returns the company ID of the first company with matching tags
        companies = self.company_service.get_company_rankings()
        for company in companies:
            company_tags = company.tags
            matching_tags = sum(1 for tag in tags if tag in company_tags)
            # Minimum of 3 matching tags to be suggested
            if matching_tags >= 3:
                return company.companyID
        return None
