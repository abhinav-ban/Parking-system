package database;
import java.time.LocalDateTime;
import java.time.Duration;
import java.sql.*;

import models.user.UserModel;




public class DatabaseConnection {
    private static String url;
    private static String user;
    private static String password;
    
    /*public static void MatrixRepresentation(String id) throws SQLException{
        String row_sql = "select row_index from matrix where id=?"; 
        String col_sql = "select col_index from matrix where id = ?";
        try(Connection con= getConnection(); PreparedStatement ps = con.prepareStatement(row_sql)){
            
        }
    }*/

    public static void setCredentials(String url, String user, String password) {
        DatabaseConnection.url = url;
        DatabaseConnection.user = user;
        DatabaseConnection.password = password;
    }

    public static void connect(){
        System.out.println("connecting with:"+url);
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void Inserting_user(UserModel user) throws SQLException{
        String sql = "insert into current_user_info(name,ph_no,car_no) values (?,?,?) ";
        String sql2 = "insert into parking_slots(vehicle_number,slot_no) values(?,?)";
        try (Connection con= getConnection(); PreparedStatement ps = con.prepareStatement(sql);PreparedStatement ps1 = con.prepareStatement(sql2)){
            ps.setString(1, user.getName());
            ps.setString(2, user.getMobileNo());
            ps.setString(3, user.getCarNo());
            ps1.setString(1, user.getCarNo());
            ps1.setString(2, user.getSlot());
            ps.executeUpdate();
            ps1.executeUpdate();
        }
    }

    public static UserModel fair(String car_n) throws SQLException{
        String exit = "select exit_time from parking_slots where vehicle_number = ?";
        String entry = "select entry_time from parking_slots where vehicle_number = ?";
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(entry);
            PreparedStatement ps1 = con.prepareStatement(exit)
        ){
            ps.setString(1, car_n);
            ps1.setString(1, car_n);
            ResultSet rs  = ps.executeQuery();
            ResultSet rs1 = ps1.executeQuery();
            if(rs.next() && rs1.next()){
                UserModel u = new UserModel(
                rs.getTimestamp("entry_time"),
                rs1.getTimestamp("exit_time"));
                return u;
            }
            return null;
        }
        
    }
    public static UserModel GUBCar_no(String car_n) throws SQLException{
        LocalDateTime time = LocalDateTime.now();
        String sql = "select * from current_user_info where car_no=?";
        String sql1 = "select * from parking_slots where vehicle_number=?";
        String sql2 = "update parking_slots set exit_time=? where vehicle_number = ?";
        try(Connection con= getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps1 = con.prepareStatement(sql1);
        PreparedStatement ps2 = con.prepareStatement(sql2)){
            
            ps.setString(1, car_n);
            ps1.setString(1, car_n);
            ps2.setTimestamp(1, java.sql.Timestamp.valueOf(time));
            ps2.setString(2, car_n);
            ResultSet rs = ps.executeQuery();
            ResultSet r = ps1.executeQuery();
            int rs2 = ps2.executeUpdate();
            if(rs.next() && r.next()){
                UserModel user = new UserModel(
                    rs.getString("name"),
                    rs.getString("ph_no"),
                    rs.getString("car_no"),
                    r.getString("slot_no")

                    );
                  
                    user.setId(rs.getString("id"));
                    return user;
            }
            return null;
        }

    }
    public static boolean verifyAdminLogin(String username, String passwordInput) throws SQLException {
        String sql = "SELECT password FROM admin_info WHERE username = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(passwordInput);
            }
        }
        return false ;
    }
    
    public static int deleteUserById(String table, String id) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate(); // returns number of rows deleted
        }
    }

    public static ResultSet getUserInfoById(String table, String id) throws SQLException {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        return ps.executeQuery(); 
    
    }


}
