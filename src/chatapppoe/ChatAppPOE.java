package chatapppoe;

import java.util.Scanner;

public class ChatAppPOE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== User Registration ===");

        System.out.print("Enter username: ");
        login.username = scanner.nextLine();

        System.out.print("Enter password: ");
        login.password = scanner.nextLine();

        System.out.print("Enter SA phone number (e.g., +27831234567): ");
        login.cellPhoneNumber = scanner.nextLine();

        System.out.print("Enter first name: ");
        login.firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        login.lastName = scanner.nextLine();

        System.out.println(login.registerUser());

        System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        boolean isLoggedIn = login.loginUser(inputUsername, inputPassword);
        System.out.println(login.returnLoginStatus(isLoggedIn));
    }
}
