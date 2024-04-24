from flask import Blueprint, jsonify
from .company_service import CompanyService

company_bp = Blueprint('company', __name__)
company_service = CompanyService()

@company_bp.route('/api', methods=['GET'])
def get_company_rankings():
    companies = company_service.get_company_rankings()
    # Convert Company objects to dictionaries before jsonify
    company_dicts = [company.__dict__ for company in companies]
    return jsonify(company_dicts)
