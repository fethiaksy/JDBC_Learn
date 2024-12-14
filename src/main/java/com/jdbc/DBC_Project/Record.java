package com.jdbc.DBC_Project;

public class Record {
    //1. Adim fields -> db column name
    private int id;
    private String isim;
    private String tel;

    public Record() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Record(int id, String isim, String tel) {
        this.id = id;
        this.isim = isim;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", isim='" + isim + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
