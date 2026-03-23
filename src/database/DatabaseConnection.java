package database;
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
    
   
    DatabaseConnection(){
        
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void Inserting_user(UserModel user) throws SQLException{
        String sql = "insert into user_info(name,ph_no,car_no) values (?,?,?) ";
        String sql2 = "insert into parking_slots(vehicle_number) values(?)";
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
    public static UserModel GUBCar_no(String car_n) throws SQLException{
        String sql = "select * from user_info where car_no=?";
        try(Connection con= getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, car_n);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UserModel user = new UserModel(
                    rs.getString("name"),
                    rs.getString("ph_no"),
                    rs.getString("car_no"),
                    rs.getString("slot")
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
