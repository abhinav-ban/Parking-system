package services.UserServices;
import database.*;
import java.time.Duration;
import java.time.Instant;

import models.user.UserModel;
import java.sql.SQLException;
import java.sql.Timestamp;

public class U_service {
    public void registerUser(String name, String mobile, String carNo,String slot) throws SQLException {
        UserModel user = new UserModel(name, mobile, carNo, slot);
        DatabaseConnection.Inserting_user(user);
        System.out.println("User registered successfully!");
    }
    public void printReceiptByCarNo(String carNo) throws SQLException {
        UserModel user = DatabaseConnection.GUBCar_no(carNo);
        //UserModel slot = DatabaseConnection.GUBCar_no(slotno);
        if (user != null) {
            System.out.println("THANK YOU " + user.getName() + "! YOUR CAR IS AT SLOT " + user.getSlot());
        } else {
            System.out.println("User not found!");
        }
    }
    public void fair_calculation(String car_no) throws SQLException{
        UserModel fair = DatabaseConnection.fair(car_no);
        if(fair == null){
            System.out.println("No record found");
            return;
        }
        Timestamp entry = fair.getentime();
        Timestamp exit = fair.getextime();
        if(entry!=null && exit != null){
            Duration duration = Duration.between(entry.toInstant(), exit.toInstant());
            System.out.println("your bill is ->$" + (duration.toHours()*5));
        }else{
            System.out.println("Enter or exit time missing");
        }

        

        //System.out.println("time on which vehicle arrived" + fair.getentime() + "gone" + fair.getextime());
        
    }
    
}
