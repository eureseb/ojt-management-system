import psycopg2
from flask import g
from config import DATABASE

def get_db():
    while 'db' not in g:
        g.db = psycopg2.connect(**DATABASE)
    print("Connected to DB")

    # Retrieve the list of tables in the database
    cursor = g.db.cursor()
    cursor.execute("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';")
    tables = cursor.fetchall()
    table_names = [table[0] for table in tables]
    print("Tables in the database:", table_names)
    return g.db

def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()
    print("Closed DB connection")