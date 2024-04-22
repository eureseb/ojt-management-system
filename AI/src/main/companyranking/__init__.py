from flask import Blueprint, jsonify

companyranking_bp = Blueprint('companyranking', __name__)

# Sample data for company ranking (placeholder)
company_rankings = [
    {
        "companyID": 1,
        "rank": 3,
        "tags": {
            "Mentorship": 0.00,
            "Allowance": 0.00,
            "Set-up": 0.00
        }
    }
]

@companyranking_bp.route('/api/companyranking')
def get_company_rankings():
    # Fetch company rankings from the database or data source
    return jsonify(company_rankings)
