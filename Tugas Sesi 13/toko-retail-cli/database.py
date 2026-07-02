import mysql.connector

def koneksi():
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="",      # Kosongkan jika password XAMPP default
        database="toko_retail"
    )