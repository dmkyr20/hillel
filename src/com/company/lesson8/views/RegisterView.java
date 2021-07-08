package com.company.lesson8.views;

import com.company.lesson8.contorllers.RegistrationController;
import com.company.lesson8.exceptions.RegistrationException;
import com.company.lesson8.models.User;

import java.util.Scanner;

public class RegisterView {

    public static void run() {
        while (true) {
            Scanner SCANNER = new Scanner(System.in);
            System.out.println("Registration started");
            System.out.println("Enter login:");
            String login = SCANNER.nextLine();

            System.out.println("Enter password:");
            String password = SCANNER.nextLine();

            System.out.println("Repeat your password:");
            String password2 = SCANNER.nextLine();

            RegistrationController controller = new RegistrationController();

            try {
                User user = controller.register(login, password, password2);
//                MainMenu.run(user);
                System.out.println("User " + user.getLogin() + " was successfully registered!");
                System.out.println("Do you want to try login?");
                System.out.println("1 - yes");
                System.out.println("2 - no");
                int answer = SCANNER.nextInt();
                if (answer == 1) {
                    LoginView.run();
                    break;
                } else if (answer == 2) {
                    System.exit(0);
                } else {
                    throw new IllegalArgumentException("Unsupported operation: " + answer);
                }
            } catch (RegistrationException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Do you want to try again?");
                System.out.println("1 - yes");
                System.out.println("2 - no");
                int answer = SCANNER.nextInt();
                if (answer == 1) {
                    // do nothing
                } else if (answer == 2) {
                    break;
                } else {
                    throw new IllegalArgumentException("Unsupported operation: " + answer);
                }
            }
        }
    }
}
