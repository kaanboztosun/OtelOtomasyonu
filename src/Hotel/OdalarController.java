package Hotel;

import entity.Filee;
import entity.Odalar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OdalarController extends Filee implements Initializable, Methods {

    private Odalar odalar;
    private static Scanner x;
    int index;
    ObservableList<Odalar> listeOdalar = FXCollections.observableArrayList();
    String room_number[] = new String[15];
    String[] type = new String[100];
    String capacity[] = new String[100];
    String avaiable[] = new String[100];
    int dolu = 0;
    String filepath = "src\\file\\odalar.txt";

    @FXML
    public TableView<Odalar> tableView;
    public TableColumn<Odalar, String> col_roomnumber;
    public TableColumn<Odalar, String> col_type;
    public TableColumn<Odalar, String> col_capacity;
    public TableColumn<Odalar, String> col_avaiable;
    @FXML
    private TextField roomnumber_text;

    @FXML
    private TextField type_text;

    @FXML
    private TextField capacity_text;

    @FXML
    private TextField avaiable_text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_roomnumber.setCellValueFactory(new PropertyValueFactory<Odalar, String>("room_number"));
        col_type.setCellValueFactory(new PropertyValueFactory<Odalar, String>("type"));
        col_capacity.setCellValueFactory(new PropertyValueFactory<Odalar, String>("capacity"));
        col_avaiable.setCellValueFactory(new PropertyValueFactory<Odalar, String>("available"));

        tableView.setItems(listeOdalar);
        read(listeOdalar, filepath);
    }

    @Override
    public void ekle(ActionEvent a) {
        if (dolu != 2) {
            String att1 = roomnumber_text.getText();
            String att2 = type_text.getText();
            String att3 = capacity_text.getText();
            String att4 = avaiable_text.getText();

            listeOdalar.add(new Odalar(att1, att2, att3, att4));
            clearform();
            write(listeOdalar, filepath);
        }
    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
        tableView.getItems().remove(index);
        //index--;
        write(listeOdalar, filepath);
        clearform();
        dolu--;
    }

    @Override
    public void guncelle(ActionEvent a) {
        listeOdalar.set(index, veriAll());
        write(listeOdalar, filepath);
        clearform();
    }

    @Override
    public void clearform() {
        roomnumber_text.clear();
        type_text.clear();
        capacity_text.clear();
        avaiable_text.clear();
    }

    @Override
    public void selectText() {
        index = tableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        roomnumber_text.setText(col_roomnumber.getCellData(index));
        type_text.setText(col_type.getCellData(index));
        capacity_text.setText(col_capacity.getCellData(index));
        avaiable_text.setText(col_avaiable.getCellData(index));
    }

    @Override
    public Odalar veriAll() {
        String at1 = roomnumber_text.getText();
        String at2 = type_text.getText();
        String at3 = capacity_text.getText();
        String at4 = avaiable_text.getText();

        return new Odalar(at1, at2, at3, at4);
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
        String tmp1;
        String tmp2;
        String tmp3;
        String tmp4;
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            int i = 0;
            while (x.hasNext()) {
                tmp1 = x.next();
                room_number[i] = tmp1;
                tmp2 = x.next();
                type[i] = tmp2;
                tmp3 = x.next();
                capacity[i] = tmp3;
                tmp4 = x.next();
                avaiable[i] = tmp4;
                listeOdalar.add(new Odalar(tmp1, tmp2, tmp3, tmp4));
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void write(Object o, String filepath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for (Odalar line : listeOdalar) {
                bw.write(line.getRoom_number() + ",");
                bw.write(line.getType() + ",");
                bw.write(line.getCapacity() + ",");
                bw.write(line.getAvailable() + "\n");

            }
            bw.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void dosyaKaydetme(ObservableList<Object> opl, File file) {
        super.dosyaKaydetme(opl, file);
    }

    @Override
    public void DosyayaYazma() {
        super.DosyayaYazma();
    }

    public Odalar getOdalar() {
        if (this.odalar == null) {
            this.odalar = new Odalar();
        }
        return odalar;
    }

    public void setOdalar(Odalar odalar) {
        this.odalar = odalar;
    }

    public String[] getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String[] room_number) {
        this.room_number = room_number;
    }

}
