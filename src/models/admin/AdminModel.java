package models.admin;

public class AdminModel {
    private String password;
    private String username;
    private String id;
    private String role;
    private String lastLogin; 
    private String activityLog;

    public AdminModel() {}

    public AdminModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AdminModel(String name, String ph_no, String car_no) {
        this.username = name;
        this.role = ph_no;
        this.activityLog = car_no;
    }

    public String getUname() { return username; }
    public String getPassword() { return password; }
    public String getID() { return id; }
    public String getRole() { return role; }
    public String getLastLogin() { return lastLogin; }

    public void setId(String id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setLastLogin(String lastLogin) { this.lastLogin = lastLogin; }

    public String toString() {
        return "Admin{" + 
               "id='" + id + '\'' +
               ", username='" + username + '\'' +
               ", role='" + role + '\'' +
               '}';
    }
}
