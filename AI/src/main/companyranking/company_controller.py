from flask import Blueprint, jsonify, request
from db import get_db
from .company_service import CompanyService

company_bp = Blueprint('company', __name__)
company_service = CompanyService()

@company_bp.route('/get_data')
def get_data():
    db = get_db()
    cursor = db.cursor()
    cursor.execute("SELECT * FROM company_evaluation")
    data = cursor.fetchall()
    return jsonify(data)

@company_bp.route('/companyranking', methods=['GET'])
def get_company_rankings():
    companies = company_service.get_company_rankings()
    # Convert Company objects to dictionaries before jsonify
    company_dicts = [company.__dict__ for company in companies]
    return jsonify(company_dicts)

@company_bp.route('/companyevaluation', methods=['GET'])
def get_company_evaluation_data():
    # Extract the company_id from the query parameters
    company_id = request.args.get('company_id')
    if not company_id:
        return jsonify({"error": "Company ID is required"}), 400
    
    # Call the CompanyService method to retrieve evaluation data
    evaluation_data = company_service.get_company_evaluation_data(company_id)
    if evaluation_data:
        return jsonify(evaluation_data)
    else:
        return jsonify({"error": "Failed to retrieve evaluation data"}), 404


  


