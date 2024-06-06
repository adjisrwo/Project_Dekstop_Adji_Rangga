package sistempelanggaran;

import java.util.Scanner;
import sistempelanggaran.Database;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Database database = new Database();
        PelanggaranManager pelanggaranManager = new PelanggaranManager(database);
//        SiswaManager siswaManager = new SiswaManager(database);
        CatatanPelanggaranManager catatanManager = new CatatanPelanggaranManager(database);

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Kelola Pelanggaran");
            System.out.println("2. Kelola Siswa");
            System.out.println("3. Kelola Catatan Pelanggaran");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    managePelanggaran(pelanggaranManager, scanner);
                    break;
                case 2:
                {
                    SiswaManager siswaManager = null;
                    manageSiswa(siswaManager, scanner);
                }
                    break;

                case 3:
                    manageCatatan(catatanManager, scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
        database.closeConnection();
    }

    private static void managePelanggaran(PelanggaranManager pelanggaranManager, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Pelanggaran:");
            System.out.println("1. Tambah Pelanggaran");
            System.out.println("2. Lihat Semua Pelanggaran");
            System.out.println("3. Update Pelanggaran");
            System.out.println("4. Hapus Pelanggaran");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    pelanggaranManager.addPelanggaran(scanner);
                    break;
                case 2:
                    pelanggaranManager.viewAllPelanggaran();
                    break;
                case 3:
                    pelanggaranManager.updatePelanggaran(scanner);
                    break;
                case 4:
                    pelanggaranManager.deletePelanggaran(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void manageSiswa(SiswaManager siswaManager, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Siswa:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Lihat Semua Siswa");
            System.out.println("3. Update Siswa");
            System.out.println("4. Hapus Siswa");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    siswaManager.addSiswa(scanner);
                    break;
                case 2:
                    siswaManager.viewAllSiswa();
                    break;
                case 3:
                    siswaManager.updateSiswa(scanner);
                    break;
                case 4:
                    siswaManager.deleteSiswa(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    private static void manageCatatan(CatatanPelanggaranManager catatanManager, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Catatan Pelanggaran:");
            System.out.println("1. Tambah Catatan Pelanggaran");
            System.out.println("2. Lihat Semua Catatan Pelanggaran");
            System.out.println("3. Update Catatan Pelanggaran");
            System.out.println("4. Hapus Catatan Pelanggaran");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    catatanManager.addCatatanPelanggaran(scanner);
                    break;
                case 2:
                    catatanManager.viewAllCatatanPelanggaran();
                    break;
                case 3:
                    catatanManager.updateCatatanPelanggaran(scanner);
                    break;
                case 4:
                    catatanManager.deleteCatatanPelanggaran(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
