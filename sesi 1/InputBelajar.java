import javax.swing.JOptionPane;

public class InputBelajar {
    public static void main(String[] args) {

        // Menampilkan kotak input
        String pelajaran = JOptionPane.showInputDialog(
                null,
                "Anda sedang belajar apa?",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Menampilkan pesan hasil input
        JOptionPane.showMessageDialog(
                null,
                "Belajar " + pelajaran + " sangat mudah",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}