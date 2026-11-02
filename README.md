# Tugas 1 Praktikum Pemrograman II - Formulir Pendaftaran Kegiatan GUI Swing

Dokumen ini berisi informasi konfigurasi, struktur komponen, panduan pengompilasian, dan pengujian untuk proyek aplikasi desktop **Formulir Pendaftaran Kegiatan** berbasis Java Swing.

---

## 1. Identitas Mahasiswa & Informasi Penugasan

| Parameter | Keterangan |
| :--- | :--- |
| **Mata Kuliah** | IF21W0508 - Praktikum Pemrograman II |
| **Modul / Penugasan** | Modul 8 / Tugas 1 Dasar GUI Swing dan Layout |
| **NIM** | 243040002 |
| **Nama Mahasiswa** | Ardhi Jamil Muchtar |
| **Kelas** | B |
| **Program Studi** | Teknik Informatika - Universitas Pasundan |

---

## 2. Spesifikasi Lingkungan Pengkodian (Environment)

| Komponen | Spesifikasi / Versi |
| :--- | :--- |
| **Bahasa Pemrograman** | JavaSE-25 |
| **Pustaka GUI** | Java Swing & AWT (`javax.swing.*`, `java.awt.*`) |
| **Integrated Development Environment (IDE)** | Eclipse IDE |
| **Sistem Operasi** | Windows 11 |
| **Arsitektur Thread** | Event Dispatch Thread (EDT) via `SwingUtilities.invokeLater` |

---

## 3. Matriks Komponen & Layout Manager

Aplikasi ini dibangun menggunakan arsitektur hirarki *container* dan *layout manager* tanpa menggunakan *absolute positioning/null layout*:

| Kelompok Antarmuka | Container & Layout Manager | Komponen Java Swing yang Digunakan |
| :--- | :--- | :--- |
| **Frame Utama** | `JFrame` (`BorderLayout`) | `JFrame`, `JPanel` utama dengan padding `EmptyBorder(12, 12, 12, 12)` |
| **Identitas Pendaftar** | `JPanel` (`GridLayout(4, 2, 8, 8)`) | `JLabel`, `JTextField` (Nama & NIM), `JComboBox` (Program Studi) |
| **Jenis Kelamin** | `JPanel` (`FlowLayout(LEFT)`) | `JRadioButton` ("Laki-laki", "Perempuan"), `ButtonGroup` |
| **Pilihan Kegiatan** | `JPanel` (`FlowLayout(LEFT)`) | `JCheckBox` ("Workshop Java Swing", "Seminar Teknologi", "Lomba Coding") |
| **Catatan / Alasan** | `JPanel` (`BorderLayout`) | `JTextArea` (4 baris, 20 kolom), `JScrollPane` (Auto-scroll) |
| **Tombol Aksi** | `JPanel` (`FlowLayout(RIGHT)`) | `JButton` ("Batal", "Daftar") |

---

## 4. Langkah Menjalankan Aplikasi (Build & Run)

### Melalui IDE (Eclipse / NetBeans / IntelliJ IDEA)
1. Ekstrak berkas `T01_243040002.zip` atau buka proyek Java di IDE Anda.
2. Pastikan struktur berkas berada pada *package* `p08`:
   ```text
   src/
    └── p08/
         └── FormPendaftaran.java
   ```
3. Buka berkas `FormPendaftaran.java`.
4. Jalankan program dengan memilih menu **Run** atau menekan kombinasi tombol `Ctrl + F11` (Eclipse) / `Shift + F6` (NetBeans).

### Melalui Command Line (Terminal / CMD)
1. Buka Terminal/Command Prompt di direktori `src`.
2. Kompilasi berkas Java:
   ```bash
   javac p08/FormPendaftaran.java
   ```
3. Jalankan aplikasi:
   ```bash
   java p08.FormPendaftaran
   ```

---

## 5. Ringkasan Matriks Pengujian Antarmuka

| Skenario Pengujian | Tindakan | Hasil yang Diharapkan | Status |
| :-: | :--- | :--- | :-: |
| **Uji Inisialisasi EDT** | Aplikasi dijalankan via `main` | GUI muncul di tengah layar via Event Dispatch Thread | **PASSED** |
| **Uji Eksklusivitas Radio** | Klik alternatif *Laki-laki* / *Perempuan* | Hanya satu `JRadioButton` yang aktif dalam satu waktu | **PASSED** |
| **Uji Urutan Fokus (Tab)** | Menekan tombol `Tab` berulang | Fokus berpindah logis dari Nama $\rightarrow$ NIM $\rightarrow$ Gender $\rightarrow$ Prodi $\rightarrow$ Kegiatan $\rightarrow$ Catatan $\rightarrow$ Tombol | **PASSED** |
| **Uji Responsif Layout** | Mengubah ukuran jendela (*Resize*) | `JTextArea` mengembang fleksibel, komponen lain tidak terpotong | **PASSED** |

---