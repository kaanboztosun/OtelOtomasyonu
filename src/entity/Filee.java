package entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Filee {

    private String a;
    private String b;
    private String c;
    private String d;

    public Filee(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Filee() {
    }

    public TableView<Object> tableView;
    private static Scanner x;
    ObservableList<Object> liste = FXCollections.observableArrayList();
    String filepath;

    public void DosyayaYazma() {
        Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("tablo kaydet");
        fileChooser.setInitialDirectory(new java.io.File(System.getProperty("user.home")));

        java.io.File file = fileChooser.showSaveDialog(secondaryStage);
        if (file != null) {
            dosyaKaydetme(tableView.getItems(), file);
        }
    }

    public void dosyaKaydetme(ObservableList<Object> opl, java.io.File file) {
        try {
            BufferedWriter outWrite = new BufferedWriter(new FileWriter(file));

            for (Object personeller : opl) {
                outWrite.write(personeller.toString());
                outWrite.newLine();
            }
            outWrite.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(Object o, String filepath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for (Object line : liste) {
                bw.write(line.getClass() + ",");
                bw.write(o.getClass() + ",");
                bw.write(o.getClass() + ",");
                bw.write(o.getClass() + "\n");
            }
            bw.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
        }
    }

    public void read(Object o, String filepath) {
        String tmp_un;
        String tmp_up;
        String tmp_uo;
        String tmp_uy;

        String fileepath;
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                tmp_un = x.next();
                tmp_up = x.next();
                tmp_uo = x.next();
                tmp_uy = x.next();
                liste.add(new Filee(tmp_un, tmp_up, tmp_uo, tmp_uy));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
