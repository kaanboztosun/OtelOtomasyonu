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

class Resepsiyonist extends Personel {

    private String odaAnahtarları;

    public Resepsiyonist() {
    }

    public Resepsiyonist(String odaAnahtarları) {
        this.odaAnahtarları = odaAnahtarları;
    }

    public String getOdaAnahtarları() {
        return odaAnahtarları;
    }

    public void setOdaAnahtarları(String odaAnahtarları) {
        this.odaAnahtarları = odaAnahtarları;
    }

    @Override
    public String toString() {
        return "Resepsiyonist{" + "odaAnahtarlar\u0131=" + odaAnahtarları + '}';
    }
}

class Vale extends Personel {

    private String araçAnahtarları;

    public Vale() {
    }

    public Vale(String araçAnahtarları) {
        this.araçAnahtarları = araçAnahtarları;
    }

    public String getAraçAnahtarları() {
        return araçAnahtarları;
    }

    public void setAraçAnahtarları(String araçAnahtarları) {
        this.araçAnahtarları = araçAnahtarları;
    }

    @Override
    public String toString() {
        return "Vale{" + "ara\u00e7Anahtarlar\u0131=" + araçAnahtarları + '}';
    }

}

class OdaServis extends Personel {

    private String servisAracı;

    public OdaServis() {
    }

    public OdaServis(String servisAracı) {
        this.servisAracı = servisAracı;
    }

    public String getServisAracı() {
        return servisAracı;
    }

    public void setServisAracı(String servisAracı) {
        this.servisAracı = servisAracı;
    }

    @Override
    public String toString() {
        return "OdaServis{" + "servisArac\u0131=" + servisAracı + '}';
    }
}
