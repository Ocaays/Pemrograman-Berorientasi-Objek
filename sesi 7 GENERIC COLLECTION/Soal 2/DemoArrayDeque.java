import java.util.ArrayDeque;

public class DemoArrayDeque {

    public static void main(String[] args) {

        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Menambah data antrian
        antrian.add("Pasien 1");
        antrian.add("Pasien 2");
        antrian.add("Pasien 3");

        System.out.println("Antrian Awal:");
        System.out.println(antrian);

        // Menghapus elemen pertama (FIFO)
        antrian.poll();

        System.out.println("Setelah satu pasien dilayani:");
        System.out.println(antrian);
    }
}