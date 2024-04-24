from flask import Blueprint, jsonify, request
from ..companyranking.company_service import CompanyService

companysuggestion_bp = Blueprint('companysuggestion', __name__)
company_service = CompanyService()

@companysuggestion_bp.route('/companysuggestion', methods=['POST'])
def get_company_suggestion():
    tags = request.json.get('tags')  
    company_id = company_service.get_company_id_by_tags(tags)
    return jsonify({'companyID': company_id})
