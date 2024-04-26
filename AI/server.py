from flask import Flask, g
import psycopg2
from src.main.companyranking.company_controller import company_bp
from src.main.companysuggestion.companysuggestion_controller import companysuggestion_bp

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
    print("Connected to DB")
    return g.db

def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()
    print("Closed DB connection")

@app.teardown_appcontext
def teardown_appcontext(exception=None):
    close_db()

def get_data():
    db = get_db()
    cursor = db.cursor()
    cursor.execute("SELECT * FROM CompanyEvaluation;")
    data = cursor.fetchall()
    return jsonify(data)

@app.route('/api/get_data')
def get_data_route():
    return get_data()

# Register blueprints
app.register_blueprint(company_bp, url_prefix='/api/')
app.register_blueprint(companysuggestion_bp, url_prefix='/api/')

if __name__ == '__main__':
    app.run(port=8010)

