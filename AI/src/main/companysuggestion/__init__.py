from flask import Blueprint, jsonify, request

companysuggestion_bp = Blueprint('companysuggestion', __name__)

# Sample data for company ranking (replace this with actual database calls)
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

def find_company_suggestion(tags):
    # Iterate through company rankings to find a match based on tags
    for company in company_rankings:
        company_tags = company['tags']
        # Check if all provided tags match with company's tags
        if all(tags.get(tag) == company_tags.get(tag) for tag in tags):
            # If all tags match, return the company ID
            return {"companyID": company['companyID']}
    # If no matching company found, return None
    return None

@companysuggestion_bp.route('/api/companysuggestion')
def get_company_suggestion():
    input_tags = request.args.get('tags')
    if not input_tags:
        return jsonify({"error": "Tags are required"}), 400
    # Convert tags string to a dictionary
    tags = eval(input_tags)  # Note: Eval is used here for simplicity, make sure to validate user input in a real application
    # Find company suggestion based on provided tags
    suggestion = find_company_suggestion(tags)
    if suggestion:
        return jsonify(suggestion)
    else:
        return jsonify({"error": "No company found with provided tags"}), 404
