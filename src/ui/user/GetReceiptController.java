package ui.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import database.DatabaseConnection;
import models.user.UserModel;

public class GetReceiptController {

    @FXML
    private TextField carNoField;
    @FXML
    private TextArea receiptArea;

    @FXML
    public void fetchReceipt() {
        try {
            String carNo = carNoField.getText().trim();
            if (carNo.isEmpty()) {
                showAlert("Please enter your car number.");
                return;
            }

            UserModel user = DatabaseConnection.GUBCar_no(carNo);

            if (user != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("======= PARKING RECEIPT =======\n");
                sb.append("Name: ").append(user.getName()).append("\n");
                sb.append("Mobile: ").append(user.getMobileNo()).append("\n");
                sb.append("Car No: ").append(user.getCarNo()).append("\n");
                sb.append("===============================");
                receiptArea.setText(sb.toString());
            } else {
                showAlert("No record found for car number: " + carNo);
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error fetching receipt: " + e.getMessage());
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
