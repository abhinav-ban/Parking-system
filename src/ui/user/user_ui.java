package ui.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.UserServices.U_service;

public class user_ui {
    @FXML private TextField nameField;
    @FXML private TextField mobileField;
    @FXML private TextField carField;

    private U_service userService = new U_service();

    public void registerUser() {
        try {
            userService.registerUser(
                nameField.getText(),
                mobileField.getText(),
                carField.getText()
            );
            showAlert("User registered successfully!");
        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
        }
    }

    public void getReceipt() {
        try {
            userService.printReceiptByCarNo(carField.getText());
        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
