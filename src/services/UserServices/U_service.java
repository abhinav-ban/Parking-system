package services.UserServices;
import database.*;
import models.user.UserModel;
import java.sql.SQLException;

public class U_service {
    public void registerUser(String name, String mobile, String carNo) throws SQLException {
        UserModel user = new UserModel(name, mobile, carNo);
        DatabaseConnection.Insertion(user);
        System.out.println("User registered successfully!");
    }
    public void printReceiptByCarNo(String carNo) throws SQLException {
        UserModel user = DatabaseConnection.GUBCar_no(carNo);
        if (user != null) {
            System.out.println("THANK YOU " + user.getName() + "! YOUR CAR IS AT SLOT " + user.getId());
        } else {
            System.out.println("User not found!");
        }
    }
    
}
