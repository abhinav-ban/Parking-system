package services.UserServices;
import database.*;
import java.time.Duration;
//import java.time.Instant;
import models.user.UserModel;
import java.sql.SQLException;
import java.sql.Timestamp;

public class U_service {
    public boolean registerUser(
        String name,
        String mobile,
        String carNo,
        String slot) throws SQLException {
        try{
            UserModel user = new UserModel(name, mobile, carNo, slot);
            DatabaseConnection.Inserting_user(user);
        return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public UserModel printReceiptByCarNo(String carNo) throws SQLException {
        return DatabaseConnection.GUBCar_no(carNo);

    }

    public long fair_calculation(String car_no) throws SQLException{
        UserModel fair = DatabaseConnection.fair(car_no);
        if(fair == null){
            throw new RuntimeException("User Not Found");
        }
        Timestamp entry = fair.getentime();
        Timestamp exit = fair.getextime();
        if(entry!=null && exit != null){
            Duration duration = Duration.between(entry.toInstant(), exit.toInstant());
            return (long)(duration.toHours()*5);
        }else{
            throw new RuntimeException("Your credentials are wrong!");
        }
    }

}
