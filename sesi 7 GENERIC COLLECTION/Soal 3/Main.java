import java.util.ArrayDeque;

public class Main {

public static void main(String[] args){

    // membuat objek buku
    Buku b1 = new BukuFiksi(
        "Laskar Pelangi",
        "Andrea Hirata"
    );

    // menampilkan data buku
    b1.info();


    // membuat objek anggota
    Anggota a1 = new Anggota("Budi");

    // menjalankan interface pinjam
    a1.pinjamBuku();


    // generic dan arraylist
    Rak<String> rak = new Rak<>();

    rak.tambah("Java Dasar");
    rak.tambah("Basis Data");

    System.out.println("Daftar Buku:");
    rak.tampil();


    // arraydeque untuk antrian
    ArrayDeque<String> antrian =
            new ArrayDeque<>();

    antrian.add("Andi");
    antrian.add("Siti");
    antrian.add("Rina");

    System.out.println(
      "Antrian : " + antrian
    );

}
}