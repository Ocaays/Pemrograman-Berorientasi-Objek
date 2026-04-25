import java.util.ArrayList;

public class DemoArrayList {

    public static void main(String[] args) {

        ArrayList<String> buku = new ArrayList<>();

        // Menambahkan data
        buku.add("Java Programming");
        buku.add("Basis Data");
        buku.add("Algoritma");

        // Menampilkan isi ArrayList
        System.out.println("Daftar Buku:");
        for(String item : buku){
            System.out.println(item);
        }
    }
}