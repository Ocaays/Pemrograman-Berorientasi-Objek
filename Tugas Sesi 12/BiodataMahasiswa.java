import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataMahasiswa extends JFrame {

    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtProdi;
    private JTextArea txtOutput;

    public BiodataMahasiswa() {
        setTitle("Aplikasi Biodata Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 480);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== Panel Input =====
        JPanel panelInput = new JPanel();
        panelInput.setBorder(new TitledBorder("Input Data"));
        panelInput.setLayout(new GridLayout(3, 2, 10, 10));

        panelInput.add(new JLabel("NIM"));
        txtNim = new JTextField();
        panelInput.add(txtNim);

        panelInput.add(new JLabel("Nama"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Program Studi"));
        txtProdi = new JTextField();
        panelInput.add(txtProdi);

        // ===== Panel Tombol =====
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton btnTampilkan = new JButton("Tampilkan");
        JButton btnReset = new JButton("Reset");
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // ===== Panel Output =====
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(new TitledBorder("Output"));

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // ===== Gabungkan panel atas (Input + Tombol) =====
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // ===== Tambahkan ke Frame =====
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // Beri sedikit margin di seluruh frame
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== Aksi Tombol Tampilkan =====
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText().trim();
                String nama = txtNama.getText().trim();
                String prodi = txtProdi.getText().trim();

                StringBuilder sb = new StringBuilder();
                sb.append("========== BIODATA MAHASISWA ==========\n\n");
                sb.append(String.format("NIM           : %s\n", nim));
                sb.append(String.format("Nama          : %s\n", nama));
                sb.append(String.format("Program Studi : %s\n", prodi));

                txtOutput.setText(sb.toString());
            }
        });

        // ===== Aksi Tombol Reset =====
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                txtOutput.setText("");
                txtNim.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BiodataMahasiswa frame = new BiodataMahasiswa();
            frame.setVisible(true);
        });
    }
}