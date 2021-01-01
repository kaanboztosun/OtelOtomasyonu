package hotel;

import entity.Filee;
import entity.Rezervasyon;
import interfaces.Methods;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RezervasyonController extends Filee implements Initializable, Methods {

    public TableView<Rezervasyon> tableView;
    public TableColumn<Rezervasyon, String> colad;
    public TableColumn<Rezervasyon, String> colsoyad;
    public TableColumn<Rezervasyon, String> coltelefon;
    public TableColumn<Rezervasyon, String> coltarih;
    private static Scanner x;
    String filepath = "src\\file\\rezervasyon.txt";
    @FXML
    private TextField adtext;

    @FXML
    private TextField soyadtext;

    @FXML
    private TextField telefontext;

    @FXML
    private TextField tarihtext;

    int index;
    ObservableList<Rezervasyon> liste = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colad.setCellValueFactory(new PropertyValueFactory<Rezervasyon, String>("ad"));
        colsoyad.setCellValueFactory(new PropertyValueFactory<Rezervasyon, String>("soyad"));
        coltelefon.setCellValueFactory(new PropertyValueFactory<Rezervasyon, String>("telefon"));
        coltarih.setCellValueFactory(new PropertyValueFactory<Rezervasyon, String>("tarih"));

        tableView.setItems(liste);
        read(liste, filepath);
    }

    @FXML
    @Override
    public void ekle(ActionEvent e) {
        try {
            String ad = adtext.getText();
            String soyad = soyadtext.getText();
            String telefon = telefontext.getText();
            String tarih = tarihtext.getText();

            liste.add(new Rezervasyon(ad, soyad, telefon, tarih));
            clearform();
            write(liste, filepath);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    @Override
    public void guncelle(ActionEvent event) {
        liste.set(index, veriAll());
        write(liste, filepath);
        clearform();

    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
        tableView.getItems().remove(index);
        index--;
        write(liste, filepath);
        clearform();
    }

    @Override
    public void clearform() {
        adtext.clear();
        soyadtext.clear();
        telefontext.clear();
        tarihtext.clear();
    }

    @Override
    public void selectText() {
        index = tableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        adtext.setText(colad.getCellData(index));
        soyadtext.setText(colsoyad.getCellData(index));
        telefontext.setText(coltelefon.getCellData(index));
        tarihtext.setText(coltarih.getCellData(index));
    }

    @Override
    public Rezervasyon veriAll() {
        String ad = adtext.getText();
        String soyad = soyadtext.getText();
        String telefon = telefontext.getText();
        String tarih = tarihtext.getText();

        return new Rezervasyon(ad, soyad, telefon, tarih);
    }

    @Override
    public void back(ActionEvent a) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void read(Object o, String filepath) {
        String tmp_un;
        String tmp_up;
        String tmp_uo;
        String tmp_uy;
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                tmp_un = x.next();
                tmp_up = x.next();
                tmp_uo = x.next();
                tmp_uy = x.next();
                liste.add(new Rezervasyon(tmp_un, tmp_up, tmp_uo, tmp_uy));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void write(Object o, String filepath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for (Rezervasyon line : liste) {
                bw.write(line.getAd() + ",");
                bw.write(line.getSoyad() + ",");
                bw.write(line.getTelefon() + ",");
                bw.write(line.getTarih() + "\n");

            }
            bw.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void dosyaKaydetme(ObservableList<Object> opl, File file) {
        super.dosyaKaydetme(opl, file); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DosyayaYazma() {
        super.DosyayaYazma();//To change body of generated methods, choose Tools | Templates.
    }

}
