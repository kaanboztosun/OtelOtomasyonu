package hotel;

import entity.Filee;
import entity.Musteri;
import interfaces.Methods;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.print.DocFlavor;

public class MusteriController extends Filee implements Initializable, Methods {

    private static Scanner x;
    int index;
    String room_number[] = new String[15];
    String type[] = new String[100];
    String capacity[] = new String[100];
    String avaiable[] = new String[100];
    @FXML
    private ComboBox<String> sec;
    private OdalarController odalarController;
    public TableView<Musteri> tableView;
    public TableColumn<Musteri, String> colAd;
    public TableColumn<Musteri, String> colSoyad;
    public TableColumn<Musteri, String> colTelefon;
    public TableColumn<Musteri, String> colGun;
    public TableColumn<Musteri, String> colRoom;
    @FXML
    public TextField Aditext;
    @FXML
    public TextField Soyadtext;
    @FXML
    public TextField Telefontext;
    @FXML
    public TextField Guntext;
    public String SecimText;
    @FXML
    ObservableList<Musteri> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String tmp6;
        String tmp7;
        String tmp8;
        String tmp9;
        String filepathh = "src\\file\\odalar.txt";
        try {
            x = new Scanner(new File(filepathh));
            x.useDelimiter("[,\n]");
            int i = 0;
            while (x.hasNext()) {
                tmp6 = x.next();
                room_number[i] = tmp6;
                tmp7 = x.next();
                type[i] = tmp7;
                tmp8 = x.next();
                capacity[i] = tmp8;
                tmp9 = x.next();
                avaiable[i] = tmp9;
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < room_number.length; i++) {
            sec.getItems().setAll(room_number);
        }
        colAd.setCellValueFactory(new PropertyValueFactory<Musteri, String>("ad"));
        colSoyad.setCellValueFactory(new PropertyValueFactory<Musteri, String>("soyad"));
        colTelefon.setCellValueFactory(new PropertyValueFactory<Musteri, String>("yas"));
        colGun.setCellValueFactory(new PropertyValueFactory<Musteri, String>("gun_sayisi"));
        colRoom.setCellValueFactory(new PropertyValueFactory<Musteri, String>("room"));
        tableView.setItems(list);
        String tmp1;
        String tmp2;
        String tmp3;
        String tmp4;
        String tmp5;

        String filepath = "src\\file\\musteri.txt";
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                tmp1 = x.next();
                tmp2 = x.next();
                tmp3 = x.next();
                tmp4 = x.next();
                tmp5 = x.next();

                list.add(new Musteri(tmp1, tmp2, tmp3, tmp4, tmp5));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    String filepath = "src\\file\\musteri.txt";

    @Override
    public void back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ekle(ActionEvent event) {

        String name = Aditext.getText();
        String surname = Soyadtext.getText();
        String age = Telefontext.getText();
        String daycount = Guntext.getText();
        String rom = sec.getSelectionModel().getSelectedItem().toString();

        list.add(new Musteri(name, surname, age, daycount, rom));
        write(list, filepath);
        clearform();

    }

    @Override
    public void guncelle(ActionEvent event) {
        list.set(index, veriAll());
        write(list, filepath);
        clearform();
    }

    @Override
    public void clearform() {
        Aditext.clear();
        Soyadtext.clear();
        Guntext.clear();
        Telefontext.clear();
    }

    @Override
    public void selectText() {
        index = tableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        Aditext.setText(colAd.getCellData(index));
        Soyadtext.setText(colSoyad.getCellData(index));
        Telefontext.setText(colTelefon.getCellData(index));
        Guntext.setText(colGun.getCellData(index));
    }

    @Override
    public Musteri veriAll() {
        String Ad = Aditext.getText();
        String Soyad = Soyadtext.getText();
        String Telefon = Telefontext.getText();
        String Gun = Guntext.getText();
        String rom = sec.getSelectionModel().getSelectedItem().toString();
        return new Musteri(Ad, Soyad, Telefon, Gun, rom);
    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
        tableView.getItems().remove(index);
        index--;
        write(list, filepath);
        clearform();
    }

    @Override
    public void write(Object o, String filepath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for (Musteri line : list) {
                bw.write(line.getAd() + ",");
                bw.write(line.getSoyad() + ",");
                bw.write(line.getYas() + ",");
                bw.write(line.getGun_sayisi() + ",");
                bw.write(line.getRoom() + "\n");
            }
            bw.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void DosyayaYazma() {
        super.DosyayaYazma();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dosyaKaydetme(ObservableList<Object> opl, File file) {
        super.dosyaKaydetme(opl, file); //To change body of generated methods, choose Tools | Templates.
    }

    public OdalarController getOdalarController() {
        if (this.odalarController == null) {
            this.odalarController = new OdalarController();
        }
        return odalarController;
    }

    public void setOdalarController(OdalarController odalarController) {
        this.odalarController = odalarController;
    }
}
