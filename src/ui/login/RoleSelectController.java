package ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RoleSelectController {

    // 🧑‍💼 Open Admin Login Screen
    public void openAdminLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(loader.load(), 700, 450);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🚗 Open User UI Directly (no login)
    public void openUserSection(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../user/user.fxml"));
            Scene scene = new Scene(loader.load(), 700, 450);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("User Panel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
