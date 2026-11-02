package p08;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class FormPendaftaran {

    private static void buatDanTampilkanGUI() {
        // 1. Frame Utama
        JFrame frame = new JFrame("Formulir Pendaftaran Kegiatan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Panel Utama menggunakan BorderLayout dengan padding 12px
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // --- KELOMPOK 1: IDENTITAS (Menggunakan GridLayout) ---
        JPanel panelIdentitas = new JPanel(new GridLayout(4, 2, 8, 8));
        panelIdentitas.setBorder(BorderFactory.createTitledBorder("Identitas Pendaftar"));

        JTextField txtNama = new JTextField(15);
        JTextField txtNim = new JTextField(15);

        // Radio Button untuk Jenis Kelamin (Saling Eksklusif via ButtonGroup)
        JRadioButton rbtLaki = new JRadioButton("Laki-laki");
        JRadioButton rbtPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbtLaki);
        bgGender.add(rbtPerempuan);

        JPanel panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelGender.add(rbtLaki);
        panelGender.add(rbtPerempuan);

        // ComboBox untuk Program Studi
        String[] daftarProdi = {"Teknik Informatika", "Teknik Industri", "Teknik Mesin", "Teknik Sipil"};
        JComboBox<String> cmbProdi = new JComboBox<>(daftarProdi);

        // Menambahkan komponen ke Panel Identitas
        panelIdentitas.add(new JLabel("Nama Lengkap:"));
        panelIdentitas.add(txtNama);
        panelIdentitas.add(new JLabel("NIM:"));
        panelIdentitas.add(txtNim);
        panelIdentitas.add(new JLabel("Jenis Kelamin:"));
        panelIdentitas.add(panelGender);
        panelIdentitas.add(new JLabel("Program Studi:"));
        panelIdentitas.add(cmbProdi);

        // --- KELOMPOK 2 & 3: PILIHAN KEGIATAN & CATATAN ---
        JPanel panelTengah = new JPanel(new BorderLayout(8, 8));

        // Kelompok Pilihan Kegiatan (FlowLayout)
        JPanel panelKegiatan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelKegiatan.setBorder(BorderFactory.createTitledBorder("Pilihan Kegiatan"));
        JCheckBox chkWorkshop = new JCheckBox("Workshop Java Swing");
        JCheckBox chkSeminar = new JCheckBox("Seminar Teknologi");
        JCheckBox chkLomba = new JCheckBox("Lomba Coding");
        panelKegiatan.add(chkWorkshop);
        panelKegiatan.add(chkSeminar);
        panelKegiatan.add(chkLomba);

        // Kelompok Catatan (JTextArea + JScrollPane)
        JPanel panelCatatan = new JPanel(new BorderLayout(5, 5));
        panelCatatan.setBorder(BorderFactory.createTitledBorder("Catatan / Alasan Mengikuti"));
        JTextArea txtCatatan = new JTextArea(4, 20);
        txtCatatan.setLineWrap(true);
        txtCatatan.setWrapStyleWord(true);
        JScrollPane scrollCatatan = new JScrollPane(txtCatatan);
        panelCatatan.add(scrollCatatan, BorderLayout.CENTER);

        panelTengah.add(panelKegiatan, BorderLayout.NORTH);
        panelTengah.add(panelCatatan, BorderLayout.CENTER);

        // --- TOMBOL AKSI (FlowLayout di posisi SOUTH) ---
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnBatal = new JButton("Batal");
        JButton btnDaftar = new JButton("Daftar");
        panelTombol.add(btnBatal);
        panelTombol.add(btnDaftar);

        // Menyusun seluruh panel ke Main Panel (BorderLayout)
        mainPanel.add(panelIdentitas, BorderLayout.NORTH);
        mainPanel.add(panelTengah, BorderLayout.CENTER);
        mainPanel.add(panelTombol, BorderLayout.SOUTH);

        // Menampilkan Frame
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Pemanggilan GUI melalui Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(FormPendaftaran::buatDanTampilkanGUI);
    }
}