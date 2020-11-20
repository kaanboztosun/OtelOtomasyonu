package Hotel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    private static Scanner x;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void exit(ActionEvent a) {
        Node source = (Node) a.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void login(ActionEvent a) throws IOException {
        boolean bulundu = false;
        String tmp_un;
        String tmp_up;
        String filepath = "src\\file\\login.txt";
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[%\n]");
            while (x.hasNext() && !bulundu) {
                tmp_un = x.next();
                tmp_up = x.next();
                if (tmp_un.trim().equals(username.getText()) && tmp_up.trim().equals(password.getText())) {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
                    Scene tableview = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
                    window.setScene(tableview);
                    window.show();
                    window.setOnCloseRequest(e -> Platform.exit());
                }
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
