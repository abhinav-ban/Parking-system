/*package ui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class ParkingGridExample extends Application {
    
    public void setWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("SLOT UNAVAILABLE");
        alert.setHeaderText(null);
        alert.setContentText("THIS SLOT HAS ALREADY BEEN BOOKED");
        alert.showAndWait();
    }

    private final int ROWS = 3;
    private final int COLS = 3;

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        //grid.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        grid.setStyle("-fx-border-color: blue; -fx-border-width: 2px; -fx-border-style: solid;");
        grid.getStylesheets().add("ParkingGridExample.css");
        
        boolean[][] slotStatus = {
            {true, false, true},
            {true, true, false},
            {false, true, true},
        };

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Button slot = new Button();
                slot.setMinSize(80, 80);  
                slot.setStyle(slotStatus[row][col] ? "-fx-background-color: green;" : "-fx-background-color: red;");

                // Make only green slots clickable
                if (slotStatus[row][col]) {
                    int r = row;  
                    int c = col;
                    slot.setOnAction(e -> openRegistrationForm(r, c));
                } else {
                    slot.setOnAction(e-> setWarning());
                }

                grid.add(slot, col, row);
            }
        }
        StackPane wrapper = new StackPane(grid);
        wrapper.setPadding(new Insets(10));
        wrapper.setStyle("-fx-border-color: black; -fx-border-width: 3px; -fx-border-style: solid;");

        Scene scene = new Scene(wrapper, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smart Parking System");
        primaryStage.show();
    }

    private void openRegistrationForm(int row, int col) {
        System.out.println("Opening registration for slot: " + (row+1) + ", " + (col+1));
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/
