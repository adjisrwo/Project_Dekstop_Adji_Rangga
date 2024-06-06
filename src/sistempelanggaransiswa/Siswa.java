import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Siswa {

    // Informasi koneksi ke database
    static final String DB_URL = "jdbc:mysql://localhost/sistempelanggaransiswa";
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        // Menambahkan siswa baru ke dalam database
        tambahSiswa("1", "Adji", "XI RPL 1", "02");
    }

    // Method untuk menambahkan siswa ke dalam tabel Siswa
    static void tambahSiswa(String ID_Nama, String Nama, String Kelas, String NoAbsen) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Query SQL untuk menambahkan siswa
            String sql = "INSERT INTO Siswa (ID_Siswa, Nama_Siswa, Kelas, No_Absen) VALUES (?, ?, ?, ?)";

            // Menyiapkan statement SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ID_Nama);
            stmt.setString(2, Nama);
            stmt.setString(3, Kelas);
            stmt.setString(4, NoAbsen);

            // Eksekusi perintah SQL
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Siswa berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan siswa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Method untuk menambahkan pelanggaran untuk siswa tertentu
    static void tambahPelanggaran(int idSiswa, String namaPelanggaran, int point, String deskripsi) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Query SQL untuk menambahkan pelanggaran
            String sql = "INSERT INTO Pelanggaran (ID_Siswa, Nama_Pelanggaran, Point, Deskripsi) VALUES (?, ?, ?, ?)";

            // Menyiapkan statement SQL
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idSiswa);
            stmt.setString(2, namaPelanggaran);
            stmt.setInt(3, point);
            stmt.setString(4, deskripsi);

            // Eksekusi perintah SQL
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pelanggaran berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan pelanggaran.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
