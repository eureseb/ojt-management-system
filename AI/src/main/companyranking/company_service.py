from flask import Flask, jsonify
from .company import Company
from .companycomment import CompanyComment
from db import get_db
from ..textclassifier.textclassifier import generate_tags

app = Flask(__name__)

class CompanyService:
    def __init__(self):
        self.populate_companies()
        for company_id, company_comment in self.company_comments.items():
            print(f"Company ID: {company_id}")
            print("Comments:")
            for comment in company_comment.comment:
                print(comment)
        
            company = self.companies.get(company_id)
            tags = generate_tags(company_comment.comment)
            
            # Check if the company exists
            if company:
                # Append the tag value to the 'tags' attribute
                company.tags.append(tags)
            else:
                # Handle case where company does not exist
                print(f"Company with ID {company_id} does not exist.")

    def populate_companies(self):
        with app.app_context():
            try:
                db = get_db()
                cursor = db.cursor()
                cursor.execute("SELECT * FROM company_evaluation")
                data = cursor.fetchall()
                self.companies = {}
                self.company_comments = {}
                for entry in data:
                    company_id = entry[1]
                    experience_evaluation = entry[5]
                    comment_dict = []

                    for e in data:
                        if company_id == e[1]:
                            comment_dict.append(e[6])

                    if company_id not in self.companies:
                        comments = CompanyComment(
                            companyID=company_id,
                            comment=comment_dict
                        )
                        self.company_comments[company_id] = comments

                        # If the company doesn't exist, create a new Company object
                        company = Company(
                            companyID=company_id,
                            tags=[],
                            rank=1,  # Placeholder value, you may update this based on evaluation status
                            experience_evaluation=[experience_evaluation]  # List to store evaluations
                        )
                        self.companies[company_id] = company
                    else:
                        # If the company already exists, append the evaluation to its list
                        self.companies[company_id].experience_evaluation.append(experience_evaluation)
                    print("Data Successfully fetched")
            except Exception as e:
                # Handle any exceptions
                print(f"Failed to fetch company data from database: {e}")
                self.companies = {}  # Set companies to an empty dict to avoid potential issues

    def get_company_rankings(self):
        # Convert the dictionary values to a list of Company objects
        return list(self.companies.values())

    def get_company_id_by_tags(self, tags):
        # Logic to retrieve company ID based on provided tags
        # For simplicity, let's assume it returns the company ID of the first company with matching tags
        for company_id, company in self.companies.items():
            if all(tag in company.tags for tag in tags):
                return company_id
        return None
