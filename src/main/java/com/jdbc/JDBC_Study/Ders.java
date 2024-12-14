package com.jdbc.JDBC_Study;

public class Ders {
    private int id;
    private  String ders_isim;
    private int egitim_suresi_gun;

    public Ders() {
    }

    public Ders(int id, String ders_isim, int egitim_suresi_gun) {
        this.id = id;
        this.ders_isim = ders_isim;
        this.egitim_suresi_gun = egitim_suresi_gun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDers_isim() {
        return ders_isim;
    }

    public void setDers_isim(String ders_isim) {
        this.ders_isim = ders_isim;
    }

    public int getEgitim_suresi_gun() {
        return egitim_suresi_gun;
    }

    public void setEgitim_suresi_gun(int egitim_suresi_gun) {
        this.egitim_suresi_gun = egitim_suresi_gun;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "id=" + id +
                ", ders_isim='" + ders_isim + '\'' +
                ", egitim_suresi_gun=" + egitim_suresi_gun +
                '}';
    }
}
