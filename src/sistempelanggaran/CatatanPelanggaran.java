/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistempelanggaran;

/**
 *
 * @author ADJI
 */
public class CatatanPelanggaran {
    private int id;
    private int idSiswa;
    private int idPelanggaran;
    private String keterangan;
    private int poin;

    public CatatanPelanggaran(int idSiswa, int idPelanggaran, String keterangan, int poin) {
        this.idSiswa = idSiswa;
        this.idPelanggaran = idPelanggaran;
        this.keterangan = keterangan;
        this.poin = poin;
    }

    public int getId() {
        return id;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public int getIdPelanggaran() {
        return idPelanggaran;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public int getPoin() {
        return poin;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CatatanPelanggaran{" +
                "id=" + id +
                ", idSiswa=" + idSiswa +
                ", idPelanggaran=" + idPelanggaran +
                ", keterangan='" + keterangan + '\'' +
                ", poin=" + poin +
                '}';
    }
}
