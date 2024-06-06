package sistempelanggaran;

import java.util.List;
import java.util.Scanner;

public class PelanggaranManager {
    private Database database;

    public PelanggaranManager(Database database) {
        this.database = database;
    }

    public void addPelanggaran(Scanner scanner) {
        System.out.print("Masukkan Bentuk Pelanggaran: ");
        String bentukPelanggaran = scanner.nextLine();
        System.out.print("Masukkan Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan Poin: ");
        int poin = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        Pelanggaran pelanggaran = new Pelanggaran(bentukPelanggaran, kategori, poin);
        database.storePelanggaran(pelanggaran);
    }

    public void viewAllPelanggaran() {
        List<Pelanggaran> pelanggaranList = database.getAllPelanggaran();
        if (pelanggaranList.isEmpty()) {
            System.out.println("Belum ada pelanggaran yang tercatat.");
        } else {
            System.out.println("Daftar Pelanggaran:");
            for (Pelanggaran pelanggaran : pelanggaranList) {
                System.out.println(pelanggaran);
            }
        }
    }

    public void updatePelanggaran(Scanner scanner) {
        System.out.print("Masukkan ID Pelanggaran yang akan diupdate: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Masukkan Bentuk Pelanggaran baru: ");
        String updateBentukPelanggaran = scanner.nextLine();
        System.out.print("Masukkan Kategori baru: ");
        String updateKategori = scanner.nextLine();
        System.out.print("Masukkan Poin baru: ");
        int updatePoin = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Pelanggaran updatedPelanggaran = new Pelanggaran(updateBentukPelanggaran, updateKategori, updatePoin);
        updatedPelanggaran.setIdPelanggaran(updateId);
        database.updatePelanggaran(updatedPelanggaran);
    }



    public void deletePelanggaran(Scanner scanner) {
        System.out.print("Masukkan ID Pelanggaran yang akan dihapus: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        database.deletePelanggaran(deleteId);
    }
}
