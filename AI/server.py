from flask import Flask
from src.main.companyranking.company_controller import company_bp

app = Flask(__name__)

# Register blueprints
app.register_blueprint(company_bp, url_prefix='/companyranking')

if __name__ == '__main__':
    app.run(port=8010)
