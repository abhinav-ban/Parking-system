package ui.admin;

import java.util.Scanner;
import models.admin.AdminModel;
import services.AdminServices.A_service;

public class admin_backend_ui {

    private Scanner scan = new Scanner(System.in);
    private A_service adminService = new A_service();

    public void startAdminUI() {
        System.out.println("==========================================");
        System.out.println("           SMART PARKING SYSTEM");
        System.out.println("==========================================");
        System.out.println("               ADMIN LOGIN");
        System.out.println("==========================================");

        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter password: ");
        String password = scan.nextLine();

        if (adminService.login(username, password)) {
            System.out.println("\nLogin successful. Welcome, " + username + "!");
            showAdminMenu();
        } else {
            System.out.println("\nLogin failed! Incorrect credentials.");
        }
    }

    private void showAdminMenu() {
        String choice;
        do {
            System.out.println("\n------------------------------------------");
            System.out.println("             ADMIN DASHBOARD");
            System.out.println("------------------------------------------");
            System.out.println("1. Delete a user");
            System.out.println("2. Get user info");
            System.out.println("3. Logout");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            int option = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (option) {
                case 1:
                    deleteUser();
                    break;
                case 2:
                    getUserInfo();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("\nDo you want to perform another operation? (yes/no): ");
            choice = scan.nextLine();

        } while (choice.equalsIgnoreCase("yes"));
    }

    private void deleteUser() {
        System.out.println("\n------------------------------------------");
        System.out.println("               DELETE USER");
        System.out.println("------------------------------------------");
        System.out.print("Enter table name: ");
        String table = scan.nextLine();
        System.out.print("Enter user ID: ");
        String id = scan.nextLine();

        boolean deleted = adminService.deleteUser(table, id);
        if (deleted) {
            System.out.println("User with ID " + id + " deleted successfully from " + table + ".");
        } else {
            System.out.println("Failed to delete user. Please check inputs.");
        }
    }

    private void getUserInfo() {
        System.out.println("\n------------------------------------------");
        System.out.println("               GET USER INFO");
        System.out.println("------------------------------------------");
        System.out.print("Enter table name: ");
        String table = scan.nextLine();
        System.out.print("Enter user ID: ");
        String id = scan.nextLine();

        AdminModel info = adminService.getUserInfo(table, id);
        if (info != null) {
            System.out.println("\n----------- USER DETAILS -----------");
            System.out.println("ID:        " + info.getID());
            System.out.println("Name:      " + info.getUname());
            System.out.println("Car No.:   " + info.getRole());
            System.out.println("------------------------------------");
        } else {
            System.out.println("No user found with ID " + id + ".");
        }
    }
}
