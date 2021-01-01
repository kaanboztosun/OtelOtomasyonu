package entity;

import java.io.Serializable;

public class Rezervasyon implements Serializable {

    private String ad;
    private String soyad;
    private String telefon;
    private String tarih;

    public Rezervasyon(String ad, String soyad, String telefon, String tarih) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.tarih = tarih;
    }

    public Rezervasyon() {
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

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "" + ad + "," + soyad + "," + telefon + "," + tarih;
    }

}
