package Hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void personel_kayit(ActionEvent a) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Personel.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void musteri(ActionEvent a) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Musteri.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void oda_kontrol(ActionEvent a) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Odalar.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void exit(ActionEvent a) {
        Node source = (Node) a.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void reserve(ActionEvent a) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Rezervasyon.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
            window.setOnCloseRequest(e -> Platform.exit());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
