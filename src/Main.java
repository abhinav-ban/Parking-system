import java.util.Scanner;
import database.DatabaseConnection;
import ui.user.user_backend_ui;
import ui.admin.admin_backend_ui;

public class Main {
    public static void main(String[] args) {
        // Set up database connection
        DatabaseConnection.setCredentials(
            "jdbc:mysql://localhost:3306/smart_parking_system",
            "root",
            "@bhI8920" 
        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= SMART PARKING SYSTEM =========");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine().trim();

        try {
            switch (choice) {
                case "1" -> {
                    user_backend_ui userUI = new user_backend_ui();
                    userUI.startUserUI();
                }
                case "2" -> {
                    admin_backend_ui adminUI = new admin_backend_ui();
                    adminUI.startAdminUI(); 
                }
                default -> System.out.println("Invalid choice! Please restart the program.");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
