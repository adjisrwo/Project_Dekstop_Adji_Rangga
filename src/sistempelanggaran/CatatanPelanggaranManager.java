/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistempelanggaran;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADJI
 */
public class CatatanPelanggaranManager {
    private Database database;

    public CatatanPelanggaranManager(Database database) {
        this.database = database;
    }

    public void addCatatanPelanggaran(Scanner scanner) {
        System.out.print("Masukkan ID Siswa: ");
        int idSiswa = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan ID Pelanggaran: ");
        int idPelanggaran = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan Keterangan: ");
        String keterangan = scanner.nextLine();

        // Fetch poin from Pelanggaran table
        int poin = database.getPoinByIdPelanggaran(idPelanggaran);

        CatatanPelanggaran catatan = new CatatanPelanggaran(idSiswa, idPelanggaran, keterangan, poin);
        database.storeCatatanPelanggaran(catatan);
    }

    public void viewAllCatatanPelanggaran() {
        List<CatatanPelanggaran> catatanList = database.getAllCatatanPelanggaran();
        if (catatanList.isEmpty()) {
            System.out.println("Belum ada catatan pelanggaran yang tercatat.");
        } else {
            System.out.println("Daftar Catatan Pelanggaran:");
            for (CatatanPelanggaran catatan : catatanList) {
                System.out.println(catatan);
            }
        }
    }
    
    public void updateCatatanPelanggaran(Scanner scanner) {
        System.out.print("Masukkan ID Catatan Pelanggaran yang akan diupdate: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan ID Siswa baru: ");
        int updateIdSiswa = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan ID Pelanggaran baru: ");
        int updateIdPelanggaran = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan Keterangan baru: ");
        String updateKeterangan = scanner.nextLine();

        // Fetch poin from Pelanggaran table
        int updatePoin = database.getPoinByIdPelanggaran(updateIdPelanggaran);

        CatatanPelanggaran updatedCatatan = new CatatanPelanggaran(updateIdSiswa, updateIdPelanggaran, updateKeterangan, updatePoin);
        updatedCatatan.setId(updateId);
        database.updateCatatanPelanggaran(updatedCatatan);
    }

    public void deleteCatatanPelanggaran(Scanner scanner) {
        System.out.print("Masukkan ID Catatan Pelanggaran yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        database.deleteCatatanPelanggaran(id);
    }
}