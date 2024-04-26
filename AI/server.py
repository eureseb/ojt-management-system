from flask import Flask
from src.main.companyranking.company_controller import company_bp
from src.main.companysuggestion.companysuggestion_controller import companysuggestion_bp
from util.database import get_db, close_db

app = Flask(__name__)

# Initialize database
@app.before_first_request
def before_first_request_func():
    init_db()

# Register teardown function to close database connection
@app.teardown_appcontext
def teardown_appcontext_func(exception=None):
    close_db()

# Register blueprints
app.register_blueprint(company_bp, url_prefix='/api/')
app.register_blueprint(companysuggestion_bp, url_prefix='/api/')

if __name__ == '__main__':
    app.run(port=8010)
