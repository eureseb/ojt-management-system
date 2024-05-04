from flask import Flask
from .company import Company
from .companycomment import CompanyComment
from db import get_db
from ..textclassifier.textclassifier import generate_tags, generate_score
import time

app = Flask(__name__)

class CompanyService:
    def __init__(self):
        # fetch Company Evaluations
        self.populate_companies()
        # Generate and Insert tags into Companies
        self.insert_tags()
        # Rank companies
        self.insert_rank()

    # Fetching evaluation data
    def populate_companies(self):
        with app.app_context():
            try:
                db = get_db()
                cursor = db.cursor()
                cursor.execute("SELECT * FROM company_evaluation")
                data = cursor.fetchall()

                self.companies = {}
                self.company_comments = {}

                # Iterate through evaluations
                for entry in data:
                    company_id = entry[1]
                    experience_evaluation = entry[5]
                    comment_dict = []

                    # Compile comments from specific companies
                    for e in data:
                        if company_id == e[1]:
                            comment_dict.append(e[6])

                    # Add unique companies and all its comments into dictionaries
                    if company_id not in self.companies:
                        # Comments from company with id: <company_id>
                        comments = CompanyComment(
                            companyID=company_id,
                            comment=comment_dict
                        )
                        # Insert into comments dict
                        self.company_comments[company_id] = comments

                        # New Company Object
                        company = Company(
                            companyID=company_id,
                            tags=[],
                            rank=0,
                            experience_evaluation=[experience_evaluation]
                        )
                        # Insert into companies dict
                        self.companies[company_id] = company
                    else:
                        # If the company already exists, append the evaluation to its list
                        self.companies[company_id].experience_evaluation.append(experience_evaluation)
            except Exception as e:
                # Handle any exceptions
                print(f"Failed to fetch company data from database: {e}")
                self.companies = {}
                self.company_comments = {}

        print("Data Successfully fetched")

    # Feeding comment batches based on <comany_id> into AI Model and updating company tags
    def insert_tags(self):
        for company_id, company_comment in self.company_comments.items():
            company = self.companies.get(company_id)
            tags = generate_tags(company_comment.comment)
            
            # Check if the company exists
            if company:
                # Set Company Tags
                company.tags = tags
        
        print("Tags Generated")
    
    def insert_rank(self):
        self.company_scores = {}
        for company_id, company_comment in self.company_comments.items():
            score = generate_score(company_comment.comment)
            self.company_scores[company_id] = score
        
        sorted_scores = sorted(self.company_scores.items(), key=lambda x: x[1])

        # Assign ranks starting from 1
        rank = 1
        for company_id, score in sorted_scores:
            # Update the rank for the corresponding Company object
            self.companies[company_id].rank = rank
            rank += 1
        
        print("Ranking Generated")

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
