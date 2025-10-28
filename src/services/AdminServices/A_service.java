package services.AdminServices;
import java.sql.*;
import database.DatabaseConnection;
import models.admin.AdminModel;

public class A_service {
    public boolean login(String username, String password) {
        try {
            return DatabaseConnection.verifyAdminLogin(username, password);
        } catch (SQLException e) {
            System.out.println("Error verifying admin login!");
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser(String table, String id) {
        try {
            int rowsDeleted = DatabaseConnection.deleteUserById(table, id);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting user!");
            e.printStackTrace();
            return false;
        }
    }
    
    
    public AdminModel getUserInfo(String table, String id) {
        try (ResultSet rs = DatabaseConnection.getUserInfoById(table, id)) {
            if (rs != null && rs.next()) {
                AdminModel info = new AdminModel(
                    rs.getString("name"),
                    rs.getString("ph_no"),
                    rs.getString("car_no")
                );
                info.setId(rs.getString("id"));
                return info;
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user info!");
            e.printStackTrace();
        }
        return null;
    }
}
