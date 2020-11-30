package entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personel implements Serializable {

    private String ad;
    private String soyad;
    private String telefon;
    private String maas;

    public Personel(String ad, String soyad, String telefon, String maas) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.maas = maas;
    }

    public Personel() {

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "" + ad + "," + soyad + "," + telefon + "," + maas;
    }
}

