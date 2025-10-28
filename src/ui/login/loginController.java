package ui.login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import services.AdminServices.A_service;


public class loginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    private A_service adminService = new A_service();

    public void loginAdmin(ActionEvent event) {
        try {
            String user = usernameField.getText();
            String pass = passwordField.getText();

            if (adminService.login(user, pass)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_ui.fxml"));
                Scene adminScene = new Scene(loader.load(), 700, 450);
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(adminScene);
            } else {
                showAlert("Invalid credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error logging in.");
        }
    }

    public void openUserMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/user/user.fxml"));
            Scene userScene = new Scene(loader.load(), 700, 450);
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(userScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
    }
}
