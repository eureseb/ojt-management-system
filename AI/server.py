from flask import Flask
from db import close_db
from src.main.companyranking.company_controller import company_bp
from src.main.companysuggestion.companysuggestion_controller import companysuggestion_bp

app = Flask(__name__)

@app.teardown_appcontext
def teardown_appcontext(exception=None):
    close_db()

# Register blueprints
app.register_blueprint(company_bp, url_prefix='/api/')
app.register_blueprint(companysuggestion_bp, url_prefix='/api/')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port='8010')