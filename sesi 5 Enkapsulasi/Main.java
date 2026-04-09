import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Student
        System.out.println("=== INPUT DATA MAHASISWA ===");
        System.out.print("Nama mahasiswa: ");
        String namaMhs = input.nextLine();

        System.out.print("Alamat mahasiswa: ");
        String alamatMhs = input.nextLine();

        Student student = new Student(namaMhs, alamatMhs);

        System.out.print("Jumlah mata kuliah: ");
        int jumlahMK = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahMK; i++) {
            System.out.print("Nama mata kuliah ke-" + (i + 1) + ": ");
            String mk = input.nextLine();

            System.out.print("Nilai: ");
            int nilai = input.nextInt();
            input.nextLine();

            student.addCourseGrade(mk, nilai);
        }

        System.out.println("\n" + student);
        student.printGrades();
        System.out.println("Rata-rata nilai: " + student.getAverageGrade());

        // Input Teacher
        System.out.println("\n=== INPUT DATA DOSEN ===");
        System.out.print("Nama dosen: ");
        String namaDosen = input.nextLine();

        System.out.print("Alamat dosen: ");
        String alamatDosen = input.nextLine();

        Teacher teacher = new Teacher(namaDosen, alamatDosen);

        System.out.print("Jumlah mata kuliah yang diampu: ");
        int jumlahAjar = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahAjar; i++) {
            System.out.print("Mata kuliah ke-" + (i + 1) + ": ");
            String mk = input.nextLine();

            if (teacher.addCourse(mk)) {
                System.out.println("Berhasil ditambahkan");
            } else {
                System.out.println("Mata kuliah sudah ada");
            }
        }

        System.out.println("\n" + teacher);

        input.close();
    }
}