package sistempelanggaran;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class SiswaManager {
    private Database database;
    private Connection connection;

    public SiswaManager(Database database) {
        this.database = database;
    }
    
    public SiswaManager(Connection connection) {
        this.connection = connection;
    }

    public void addSiswa(Scanner scanner) {
        System.out.print("Masukkan Nama Siswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Kelas: ");
        String jurusan = scanner.nextLine();
        System.out.print("Masukkan Nomor Absen: ");
        int noAbsen = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        SiswaFrame siswa = new SiswaFrame(nama, jurusan, noAbsen);
        database.storeSiswa(siswa);
    }

    public void viewAllSiswa() {
        List<SiswaFrame> siswaList = database.getAllSiswa();
        if (siswaList.isEmpty()) {
            System.out.println("Belum ada siswa yang tercatat.");
        } else {
            System.out.println("Daftar Siswa:");
            for (SiswaFrame siswa : siswaList) {
                System.out.println(siswa);
            }
        }
    }

    public void updateSiswa(Scanner scanner) {
        System.out.print("Masukkan ID Siswa yang akan diupdate: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan Nama Siswa baru: ");
        String updateNama = scanner.nextLine();
        System.out.print("Masukkan Jurusan baru: ");
        String updateJurusan = scanner.nextLine();
        System.out.print("Masukkan Nomor Absen baru: ");
        int updateNoAbsen = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        SiswaFrame updatedSiswa = new SiswaFrame(updateNama, updateJurusan, updateNoAbsen);
        updatedSiswa.setIdSiswa(updateId);
        database.updateSiswa(updatedSiswa);
    }

    public void updateSiswa(SiswaFrame siswa) {
        String sql = "UPDATE siswa SET nama = ?, kelas = ?, no_absen = ? WHERE id = ?";
        try (java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, siswa.getNamaSiswa());
            statement.setString(2, siswa.getKelas());
            statement.setInt(3, siswa.getNoAbsen());
            statement.setInt(4, siswa.getIdSiswa());
            statement.executeUpdate();
            System.out.println("Siswa berhasil diperbarui di database.");
        } catch (SQLException e) {
            System.out.println("Error updating siswa: " + e.getMessage());
        }
    }

    public void deleteSiswa(Scanner scanner) {
        System.out.print("Masukkan ID Siswa yang akan dihapus: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        database.deleteSiswa(deleteId);
    }
}
