from flask import Flask
from src.main.companyranking import companyranking_bp
from src.main.companysuggestion import companysuggestion_bp

app = Flask(__name__)

# Register blueprints
app.register_blueprint(companyranking_bp)
app.register_blueprint(companysuggestion_bp)

if __name__ == '__main__':
    app.run(port=8010)
