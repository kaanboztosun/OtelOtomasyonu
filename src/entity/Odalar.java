package entity;

public class Odalar {

    private String room_number;
    private String type;
    private String capacity;
    private String available;

    public Odalar(String room_number, String type, String capacity, String available) {
        this.room_number = room_number;
        this.type = type;
        this.capacity = capacity;
        this.available = available;
    }

    public Odalar() {
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return room_number + "," + type + "," + capacity + "," + available;
    }

}

class SuitOda extends Odalar {

    private String ebeveynBanyosu;
    private String oyunAlanı;
     private int balkonAdedi;
        
   
    public SuitOda() {
    }

    public SuitOda(String ebeveynBanyosu, String oyunAlanı) {
        this.ebeveynBanyosu = ebeveynBanyosu;
        this.oyunAlanı = oyunAlanı;
    }

    public String getEbeveynBanyosu() {
        return ebeveynBanyosu;
    }

    public void setEbeveynBanyosu(String ebeveynBanyosu) {
        this.ebeveynBanyosu = ebeveynBanyosu;
    }

    public String getOyunAlanı() {
        return oyunAlanı;
    }

    public void setOyunAlanı(String oyunAlanı) {
        this.oyunAlanı = oyunAlanı;
    }

    @Override
    public String toString() {
        return "SuitOda{" + "ebeveynBanyosu=" + ebeveynBanyosu + ", oyunAlan\u0131=" + oyunAlanı + '}';
    }
}

class StandartOda extends Odalar {

    private String televizyon;
    private String banyo;
    

    public StandartOda() {
    }

    public StandartOda(String televizyon, String banyo) {
        this.televizyon = televizyon;
        this.banyo = banyo;
    }

    public String getTelevizyon() {
        return televizyon;
    }

    public void setTelevizyon(String televizyon) {
        this.televizyon = televizyon;
    }

    public String getBanyo() {
        return banyo;
    }

    public void setBanyo(String banyo) {
        this.banyo = banyo;
    }

    @Override
    public String toString() {
        return "StandartOda{" + "televizyon=" + televizyon + ", banyo=" + banyo + '}';
    }
}

class KralDairesi extends Odalar {

    private String miniBar;
    private String oyunKonsolu;
    private String havuz;
    private String sauna;
   

    public KralDairesi() {
    }

    public KralDairesi(String miniBar, String oyunKonsolu, String havuz, String sauna) {
        this.miniBar = miniBar;
        this.oyunKonsolu = oyunKonsolu;
        this.havuz = havuz;
        this.sauna = sauna;
    }

    public String getMiniBar() {
        return miniBar;
    }

    public void setMiniBar(String miniBar) {
        this.miniBar = miniBar;
    }

    public String getOyunKonsolu() {
        return oyunKonsolu;
    }

    public void setOyunKonsolu(String oyunKonsolu) {
        this.oyunKonsolu = oyunKonsolu;
    }

    public String getHavuz() {
        return havuz;
    }

    public void setHavuz(String havuz) {
        this.havuz = havuz;
    }

    public String getSauna() {
        return sauna;
    }

    public void setSauna(String sauna) {
        this.sauna = sauna;
    }

    @Override
    public String toString() {
        return "KralDairesi{" + "miniBar=" + miniBar + ", oyunKonsolu=" + oyunKonsolu + ", havuz=" + havuz + ", sauna=" + sauna + '}';
    }
}
