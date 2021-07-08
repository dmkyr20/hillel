package com.company.lesson8.lesson.views;

import com.company.lesson8.lesson.contorllers.RegistrationController;
import com.company.lesson8.lesson.exceptions.RegistrationException;
import com.company.lesson8.lesson.models.User;
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
                MainMenu.run(user);
                return;
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
