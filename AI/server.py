from flask import Flask, g
from src.main.companyranking.company_controller import company_bp
from src.main.companysuggestion.companysuggestion_controller import companysuggestion_bp
from util.database import get_db, close_db, init_app

app = Flask(__name__)

DATABASE = {
    'dbname': 'intern_db',
    'user': 'postgres',
    'password': 'postgres',
    'host': 'localhost',
    'port': '5432'
}

def get_db():
    if 'db' not in g:
        g.db = psycopg2.connect(**DATABASE)
    return g.db

def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()

db = get_db()

@app.teardown_appcontext
def teardown_appcontext(exception=None):
    close_db()

# Register blueprints
app.register_blueprint(company_bp, url_prefix='/api/')
app.register_blueprint(companysuggestion_bp, url_prefix='/api/')

if __name__ == '__main__':
    app.run(port=8010)
