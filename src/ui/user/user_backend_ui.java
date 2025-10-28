package ui.user;

import java.util.Scanner;
import services.UserServices.U_service;
import java.sql.SQLException;

public class user_backend_ui {
    private final U_service userService = new U_service();
    private final Scanner scanner = new Scanner(System.in);

    public void startUserUI() {
        while (true) {
            System.out.println("\n=== SMART PARKING SYSTEM ===");
            System.out.println("1. Register Car");
            System.out.println("2. Get Parking Receipt");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> register();
                case "2" -> receipt();
                case "3" -> {
                    System.out.println("Exiting Smart Parking System. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void register() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter your car number: ");
        String carNo = scanner.nextLine();

        try {
            userService.registerUser(name, mobile, carNo);
        } catch (SQLException e) {
            System.out.println("Error registering user. Please try again.");
            e.printStackTrace();
        }
    }

    private void receipt() {
        System.out.print("Enter your car number: ");
        String carNo = scanner.nextLine();

        try {
            userService.printReceiptByCarNo(carNo);
        } catch (SQLException e) {
            System.out.println("Error fetching receipt. Please try again.");
            e.printStackTrace();
        }
    }
}
