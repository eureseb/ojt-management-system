import psycopg2
from flask import g
from config import DATABASE

# fetch db
def get_db():
    while 'db' not in g:
        g.db = psycopg2.connect(**DATABASE)
    print("Connected to DB")
    return g.db

# close connection
def close_db():
    db = g.pop('db', None)
    if db is not None:
        db.close()
    print("Closed DB connection")