from database import koneksi

# ==========================
# MENU 1 : TAMPIL DATA
# ==========================
def tampil():
    db = koneksi()
    cursor = db.cursor()

    cursor.execute("SELECT * FROM barang")
    data = cursor.fetchall()

    print("\n" + "=" * 60)
    print("             DAFTAR BARANG TOKO RETAIL")
    print("=" * 60)
    print("{:<3} {:<8} {:<20} {:<10} {:<5}".format(
        "No", "Kode", "Nama Barang", "Harga", "Stok"))
    print("-" * 60)

    for i, row in enumerate(data, start=1):
        print("{:<3} {:<8} {:<20} {:<10} {:<5}".format(
            i, row[0], row[1], row[2], row[3]))

    print("=" * 60)
    print(f"Total : {len(data)} barang\n")

    db.close()


# ==========================
# MENU 2 : TAMBAH DATA
# ==========================
def tambah():
    db = koneksi()
    cursor = db.cursor()

    print("\n=== TAMBAH DATA BARANG ===")

    kode = input("Kode Barang : ")
    nama = input("Nama Barang : ")
    harga = int(input("Harga       : "))
    stok = int(input("Stok        : "))

    sql = """
    INSERT INTO barang(kode,nama_barang,harga,stok)
    VALUES(%s,%s,%s,%s)
    """

    try:
        cursor.execute(sql, (kode, nama, harga, stok))
        db.commit()
        print("\nData berhasil ditambahkan.")
    except Exception as e:
        print("\nGagal menambahkan data.")
        print(e)

    db.close()


# ==========================
# MENU 3 : CARI DATA
# ==========================
def cari():
    db = koneksi()
    cursor = db.cursor()

    kode = input("\nMasukkan Kode Barang : ")

    cursor.execute(
        "SELECT * FROM barang WHERE kode=%s",
        (kode,)
    )

    data = cursor.fetchone()

    if data:
        print("\nData ditemukan")
        print("-" * 30)
        print("Kode  :", data[0])
        print("Nama  :", data[1])
        print("Harga :", data[2])
        print("Stok  :", data[3])
    else:
        print("Data tidak ditemukan.")

    db.close()


# ==========================
# MENU 4 : UBAH DATA
# ==========================
def ubah():
    db = koneksi()
    cursor = db.cursor()

    kode = input("\nMasukkan Kode Barang yang diubah : ")

    cursor.execute(
        "SELECT * FROM barang WHERE kode=%s",
        (kode,)
    )

    data = cursor.fetchone()

    if data:

        print("\nData Lama")
        print("Nama :", data[1])
        print("Harga :", data[2])
        print("Stok :", data[3])

        nama = input("\nNama Baru : ")
        harga = int(input("Harga Baru : "))
        stok = int(input("Stok Baru : "))

        sql = """
        UPDATE barang
        SET nama_barang=%s,
            harga=%s,
            stok=%s
        WHERE kode=%s
        """

        cursor.execute(sql, (nama, harga, stok, kode))
        db.commit()

        print("\nData berhasil diubah.")

    else:
        print("Data tidak ditemukan.")

    db.close()


# ==========================
# MENU 5 : HAPUS DATA
# ==========================
def hapus():
    db = koneksi()
    cursor = db.cursor()

    kode = input("\nMasukkan Kode Barang yang dihapus : ")

    cursor.execute(
        "SELECT * FROM barang WHERE kode=%s",
        (kode,)
    )

    data = cursor.fetchone()

    if data:

        konfirmasi = input(
            f"Yakin ingin menghapus {data[1]}? (y/t) : "
        )

        if konfirmasi.lower() == "y":

            cursor.execute(
                "DELETE FROM barang WHERE kode=%s",
                (kode,)
            )

            db.commit()
            print("Data berhasil dihapus.")

        else:
            print("Penghapusan dibatalkan.")

    else:
        print("Data tidak ditemukan.")

    db.close()


# ==========================
# MENU UTAMA
# ==========================

while True:

    print("""
====================================
          MENU TOKO RETAIL
====================================
1. Tampil Semua Data
2. Tambah Data
3. Cari Data
4. Ubah Data
5. Hapus Data
0. Keluar
====================================
""")

    pilih = input("Pilihan : ")

    if pilih == "1":
        tampil()

    elif pilih == "2":
        tambah()

    elif pilih == "3":
        cari()

    elif pilih == "4":
        ubah()

    elif pilih == "5":
        hapus()

    elif pilih == "0":
        print("\nTerima kasih.")
        break

    else:
        print("\nPilihan tidak tersedia.")