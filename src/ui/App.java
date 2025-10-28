package ui;

import database.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        DatabaseConnection.setCredentials(
            "jdbc:mysql://localhost:3306/smart_parking_system",
            "root",
            "@bhI8920"
        );


        FXMLLoader loader = new FXMLLoader(getClass().getResource("login/role_select.fxml"));
        Scene scene = new Scene(loader.load(), 700, 450);
        stage.setScene(scene);
        stage.setTitle("Smart Parking System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
