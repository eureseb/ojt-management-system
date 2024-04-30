import psycopg2
from flask import g
from config import DATABASE

def get_db():
    while 'db' not in g:
        g.db = psycopg2.connect(**DATABASE)
    print("Connected to DB")
    return g.db

def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()
    print("Closed DB connection")