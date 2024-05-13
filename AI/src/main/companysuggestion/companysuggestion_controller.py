from flask import Blueprint, jsonify, request
from ..companysuggestion.companysuggestion_service import CompanySuggestionService
import json

companysuggestion_bp = Blueprint('companysuggestion', __name__)
company_suggestion_service = CompanySuggestionService()

@companysuggestion_bp.route('/companysuggestion', methods=['POST'])
def get_company_suggestion():
    tags = request.json.get('tags')
    print(tags)
    company_ids = company_suggestion_service.get_company_id_by_tags(tags)
    return jsonify({'companyIDs': company_ids})
