/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistempelanggaran;

/**
 *
 * @author ADJI
 */
public class Pelanggaran {
    private int idPelanggaran;
    private String bentukPelanggaran;
    private String kategori;
    private int poin;

    public Pelanggaran(int idPelanggaran, String bentukPelanggaran, String kategori, int poin) {
        this.idPelanggaran = idPelanggaran;
        this.bentukPelanggaran = bentukPelanggaran;
        this.kategori = kategori;
        this.poin = poin;
    }
    

    public int getId() {
        return idPelanggaran;
    }
    
    public void setIdPelanggaran(int idPelanggaran) {
        this.idPelanggaran = idPelanggaran;
    }

    public String getBentukPelanggaran() {
        return bentukPelanggaran;
    }

    public void setBentukPelanggaran(String bentukPelanggaran) {
        this.bentukPelanggaran = bentukPelanggaran;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    @Override
    public String toString() {
        return "Pelanggaran{" +
                "id=" + idPelanggaran +
                ", bentukPelanggaran='" + bentukPelanggaran + '\'' +
                ", kategori='" + kategori + '\'' +
                ", poin=" + poin +
                '}';
    }
}