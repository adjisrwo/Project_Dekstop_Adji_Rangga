/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistempelanggaran;

/**
 *
 * @author ADJI
 */
public class Siswa {
    private int id;
    private String nama;
    private String kelas;
    private int noAbsen;

    public Siswa(int id, String nama, String kelas, int noAbsen) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.noAbsen = noAbsen;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public int getNoAbsen() {
        return noAbsen;
    }
}
