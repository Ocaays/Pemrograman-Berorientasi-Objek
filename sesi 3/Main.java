import java.util.Scanner;

class Mahasiswa {
    String nim, nama, grade;
    int nilai;

    void hitungGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
        } else if (nilai >= 70) {
            grade = "B";
        } else if (nilai >= 60) {
            grade = "C";
        } else if (nilai >= 50) {
            grade = "D";
        } else {
            grade = "E";
        }
    }

    boolean isLulus() {
        return grade.equals("A") || grade.equals("B") || grade.equals("C");
    }

    void tampil() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
        System.out.println("=================================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlah = 4; // sesuai contoh soal
        Mahasiswa[] mhs = new Mahasiswa[jumlah];

        int total = 0;

        String lulusNama = "";
        String tidakLulusNama = "";

        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0;

        for (int i = 0; i < jumlah; i++) {
            mhs[i] = new Mahasiswa();

            System.out.print("NIM   : ");
            mhs[i].nim = input.nextLine();

            System.out.print("Nama  : ");
            mhs[i].nama = input.nextLine();

            System.out.print("Nilai : ");
            mhs[i].nilai = input.nextInt();
            input.nextLine();

            mhs[i].hitungGrade();
            total += mhs[i].nilai;

            // Hitung grade
            switch (mhs[i].grade) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
                case "E": countE++; break;
            }

            // Lulus / tidak
            if (mhs[i].isLulus()) {
                if (!lulusNama.isEmpty()) lulusNama += ", ";
                lulusNama += mhs[i].nama;
            } else {
                if (!tidakLulusNama.isEmpty()) tidakLulusNama += ", ";
                tidakLulusNama += mhs[i].nama;
            }
        }

        // Output data mahasiswa
        System.out.println("\n===== DATA MAHASISWA =====");
        for (int i = 0; i < jumlah; i++) {
            mhs[i].tampil();
        }

        double rata = (double) total / jumlah;

        // Output rekap sesuai gambar
        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + (countA + countB + countC) + " yaitu " + lulusNama);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + (countD + countE) + " yaitu " + tidakLulusNama);

        System.out.println("Jumlah Mahasiswa dengan Nilai A : " + countA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B : " + countB);
        System.out.println("Jumlah Mahasiswa dengan Nilai C : " + countC);
        System.out.println("Jumlah Mahasiswa dengan Nilai D : " + countD);
        System.out.println("Jumlah Mahasiswa dengan Nilai E : " + countE);

        System.out.println("Rata-rata nilai mahasiswa adalah : " + rata);
    }
}