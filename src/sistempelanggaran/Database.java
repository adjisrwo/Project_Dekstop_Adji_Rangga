package sistempelanggaran;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database() {
        connectDatabase();
    }

    private void connectDatabase() {
        String url = "jdbc:mysql://localhost:3306/pelanggaran_database";
        String user = "pelanggaran_user";
        String password = "password";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

//    public void storeSiswa(Siswa siswa) {
//        String sql = "INSERT INTO siswa (nama, kelas, no_absen) VALUES (?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, siswa.getNamaSiswa());
//            statement.setString(2, siswa.getKelas());
//            statement.setInt(3, siswa.getNoAbsen());
//            int affectedRows = statement.executeUpdate();
//
//            if (affectedRows == 0) {
//                throw new SQLException("Creating siswa failed, no rows affected.");
//            }
//
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    siswa.setIdSiswa(generatedKeys.getInt(1));
//                    System.out.println("Siswa berhasil disimpan ke database dengan ID: " + siswa.getIdSiswa());
//                } else {
//                    throw new SQLException("Creating siswa failed, no ID obtained.");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Error saving siswa: " + e.getMessage());
//        }
//    }

    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();
        String sql = "SELECT * FROM siswa";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas"); // Assuming column name is 'jurusan'
                int noAbsen = rs.getInt("no_absen");
                Siswa siswa = new Siswa(id, nama, kelas, noAbsen);
                siswaList.add(siswa);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching siswa data: " + e.getMessage());
        }
        return siswaList;
    }


//    public void updateSiswa(SiswaFrame siswa) {
//        String sql = "UPDATE siswa SET nama = ?, kelas = ?, no_absen = ? WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, siswa.getNamaSiswa());
//            statement.setString(2, siswa.getKelas());
//            statement.setInt(3, siswa.getNoAbsen());
//            statement.setInt(4, siswa.getIdSiswa());
//            statement.executeUpdate();
//            System.out.println("Siswa berhasil diperbarui di database.");
//        } catch (SQLException e) {
//            System.out.println("Error updating siswa: " + e.getMessage());
//        }
//    }

    public void deleteSiswa(int id) {
        String sql = "DELETE FROM siswa WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Siswa berhasil dihapus dari database.");
        } catch (SQLException e) {
            System.out.println("Error deleting siswa: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
    
    public boolean storePelanggaran(String bentukPelanggaran, String kategori, int poin) {
        String sql = "INSERT INTO pelanggaran (bentuk_pelanggaran, kategori, poin) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bentukPelanggaran);
            statement.setString(2, kategori);
            statement.setInt(3, poin);
            statement.executeUpdate();
            System.out.println("Pelanggaran berhasil disimpan ke database.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error saving pelanggaran: " + e.getMessage());
            return false;
        }
    }
    
    public int insertPelanggaran(String bentukPelanggaran, String kategori, int poin) {
    String sql = "INSERT INTO pelanggaran (bentuk_pelanggaran, kategori, poin) VALUES (?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, bentukPelanggaran);
        statement.setString(2, kategori);
        statement.setInt(3, poin);
        statement.executeUpdate();

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating pelanggaran failed, no ID obtained.");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error inserting new pelanggaran: " + e.getMessage());
        return -1;
    }
}


    public void updatePelanggaran(int id, String bentukPelanggaran, String kategori, int poin) {
        String sql = "UPDATE pelanggaran SET bentuk_pelanggaran = ?, kategori = ?, poin = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, bentukPelanggaran);
            statement.setString(3, kategori);
            statement.setInt(4, poin);
            statement.executeUpdate();
            System.out.println("Pelanggaran berhasil diperbarui di database.");
        } catch (SQLException e) {
            System.out.println("Error updating pelanggaran: " + e.getMessage());
        }
    }

    public void deletePelanggaran(int id) {
        String sql = "DELETE FROM pelanggaran WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Pelanggaran berhasil dihapus dari database.");
        } catch (SQLException e) {
            System.out.println("Error deleting pelanggaran: " + e.getMessage());
        }
    }

    public List<Pelanggaran> getAllPelanggaran() {
        List<Pelanggaran> pelanggaranList = new ArrayList<>();
        String sql = "SELECT * FROM pelanggaran";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPelanggaran = rs.getInt("id");
                String bentukPelanggaran = rs.getString("bentuk_pelanggaran");
                String kategori = rs.getString("kategori");
                int poin = rs.getInt("poin");
                Pelanggaran pelanggaran = new Pelanggaran(idPelanggaran, bentukPelanggaran, kategori, poin);
                pelanggaranList.add(pelanggaran);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pelanggaran data: " + e.getMessage());
        }
        return pelanggaranList;
    }   
    
    public void storeCatatanPelanggaran(int idSiswa, int idPelanggaran) {
        String sql = "INSERT INTO catatan_pelanggaran (id_siswa, id_pelanggaran, keterangan, poin) SELECT ?, ?, bentuk_pelanggaran, poin FROM pelanggaran WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, idSiswa);
            statement.setInt(2, idPelanggaran);
            statement.setInt(3, idPelanggaran);
            statement.executeUpdate();

            System.out.println("Catatan Pelanggaran berhasil disimpan ke database.");
        } catch (SQLException e) {
            System.out.println("Error saving catatan pelanggaran: " + e.getMessage());
        }
    }




    public List<CatatanPelanggaran> getAllCatatanPelanggaran() {
        List<CatatanPelanggaran> catatanList = new ArrayList<>();
        String sql = "SELECT * FROM catatan_pelanggaran";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idSiswa = rs.getInt("id_siswa");
                int idPelanggaran = rs.getInt("id_pelanggaran");
                String keterangan = rs.getString("keterangan");
                int poin = rs.getInt("poin");
                CatatanPelanggaran catatan = new CatatanPelanggaran(idSiswa, idPelanggaran, keterangan, poin);
                catatan.setId(id);
                catatanList.add(catatan);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching catatan pelanggaran data: " + e.getMessage());
        }
        return catatanList;
    }
    
    public String getStudentName(int studentId) {
    String sql = "SELECT nama FROM siswa WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("nama");
        }
    } catch (SQLException e) {
        System.out.println("Error fetching student name: " + e.getMessage());
    }
    return null;
}
    
    public List<String> getKategoriByBentukPelanggaran(String bentukPelanggaran) {
        List<String> kategoriList = new ArrayList<>();
        String sql = "SELECT DISTINCT kategori FROM pelanggaran WHERE bentuk_pelanggaran = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bentukPelanggaran);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String kategori = rs.getString("kategori");
                kategoriList.add(kategori);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching kategori data: " + e.getMessage());
        }
        return kategoriList;
    }

    public Pelanggaran getPelanggaranByBentuk(String bentukPelanggaran) {
        String sql = "SELECT * FROM pelanggaran WHERE bentuk_pelanggaran = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bentukPelanggaran);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idPelanggaran = rs.getInt("id");
                String kategori = rs.getString("kategori");
                int poin = rs.getInt("poin");
                return new Pelanggaran(idPelanggaran, bentukPelanggaran, kategori, poin);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pelanggaran data: " + e.getMessage());
        }
        return null;
    }


    public int getPoin(String bentukPelanggaran, String kategori) {
        int poin = 0;
        String sql = "SELECT poin FROM pelanggaran WHERE bentuk_pelanggaran = ? AND kategori = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bentukPelanggaran);
            statement.setString(2, kategori);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                poin = rs.getInt("poin");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching poin data: " + e.getMessage());
        }
        return poin;
    }


    public void updateCatatanPelanggaran(CatatanPelanggaran catatan) {
        String sql = "UPDATE catatan_pelanggaran SET id_siswa = ?, id_pelanggaran = ?, keterangan = ?, poin = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, catatan.getIdSiswa());
            statement.setInt(2, catatan.getIdPelanggaran());
            statement.setString(3, catatan.getKeterangan());
            statement.setInt(4, catatan.getPoin());
            statement.setInt(5, catatan.getId());
            statement.executeUpdate();
            System.out.println("Catatan Pelanggaran berhasil diperbarui di database.");
        } catch (SQLException e) {
            System.out.println("Error updating catatan pelanggaran: " + e.getMessage());
        }
    }

    public void deleteCatatanPelanggaran(int id) {
        String sql = "DELETE FROM catatan_pelanggaran WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Catatan Pelanggaran berhasil dihapus dari database.");
        } catch (SQLException e) {
            System.out.println("Error deleting catatan pelanggaran: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
