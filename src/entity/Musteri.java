package entity;

public class Musteri {

    private String ad;
    private String soyad;
    private String yas;
    private String gun_sayisi;
    private String room;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String yas, String gun_sayisi, String room) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.gun_sayisi = gun_sayisi;
        this.room = room;
    }

    public Musteri(String ad, String soyad, String yas, String gun_sayisi) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.gun_sayisi = gun_sayisi;
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

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getGun_sayisi() {
        return gun_sayisi;
    }

    public void setGun_sayisi(String gun_sayisi) {
        this.gun_sayisi = gun_sayisi;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "" + ad + "," + soyad + "," + yas + "," + gun_sayisi + "," + room;
    }

}
