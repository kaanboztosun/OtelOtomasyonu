package Hotel;

import entity.Filee;
import entity.Personel;
import interfaces.Methods;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PersonelController extends Filee implements Initializable, Methods {

    public TableView<Personel> tableView;
    public TableColumn<Personel, String> colad;
    public TableColumn<Personel, String> colsoyad;
    public TableColumn<Personel, String> coltelefon;
    public TableColumn<Personel, String> colmaas;
    String filepath = "src\\file\\personel.txt";
    private static Scanner x;

    @FXML
    private TextField adtext;

    @FXML
    private TextField soyadtext;

    @FXML
    private TextField teletext;

    @FXML
    private TextField maastext;

    int index;
    ObservableList<Personel> liste = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colad.setCellValueFactory(new PropertyValueFactory<Personel, String>("ad"));
        colsoyad.setCellValueFactory(new PropertyValueFactory<Personel, String>("soyad"));
        coltelefon.setCellValueFactory(new PropertyValueFactory<Personel, String>("telefon"));
        colmaas.setCellValueFactory(new PropertyValueFactory<Personel, String>("maas"));

        tableView.setItems(liste);
        read(liste, filepath);
    }

    @Override
    public void ekle(ActionEvent e) {
        String ad = adtext.getText();
        String soyad = soyadtext.getText();
        String tele = teletext.getText();
        String maas = maastext.getText();

        liste.add(new Personel(ad, soyad, tele, maas));
        //this.p=new Personel(ad, soyad, tele, maas);
        //dosyaKaydetme(tableView.getItems(), file);
        write(liste, filepath);
        clearform();
    }

    @Override
    public void guncelle(ActionEvent event) {
        liste.set(index, veriAll());
        write(liste, filepath);
        clearform();
    }

    @Override
    public Personel veriAll() {
        String ad = adtext.getText();
        String soyad = soyadtext.getText();
        String tele = teletext.getText();
        String maas = maastext.getText();

        return new Personel(ad, soyad, tele, maas);
    }

    @Override
    public void selectText() {
        index = tableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        adtext.setText(colad.getCellData(index));
        soyadtext.setText(colsoyad.getCellData(index));
        teletext.setText(coltelefon.getCellData(index));
        maastext.setText(colmaas.getCellData(index));
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
        maastext.clear();
        teletext.clear();
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
    public void write(Object p, String fileepath) {
        super.write(p, fileepath);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileepath));
            for (Personel line : liste) {
                bw.write(line.getAd() + ",");
                bw.write(line.getSoyad() + ",");
                bw.write(line.getTelefon() + ",");
                bw.write(line.getMaas() + "\n");
            }
            bw.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
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
                liste.add(new Personel(tmp_un, tmp_up, tmp_uo, tmp_uy));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void DosyayaYazma() {
        super.DosyayaYazma();
    }

    @Override
    public void dosyaKaydetme(ObservableList<Object> opl, File file) {
        super.dosyaKaydetme(opl, file);
    }
}
