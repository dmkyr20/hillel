package com.company.lesson8.lesson.views;

import com.company.lesson8.lesson.contorllers.LoginController;
import com.company.lesson8.lesson.exceptions.LoginException;
import com.company.lesson8.lesson.models.User;
import java.util.Scanner;

public class LoginView {
    public static void run() {
//        System.out.println("Login started");

        while (true) {
            // FIXME: If your scanner isn't a final static, you shouldn't name it in upper case
            Scanner SCANNER = new Scanner(System.in);
            System.out.println("Login started");
            System.out.println("Enter login:");
            String login = SCANNER.nextLine();

            System.out.println("Enter password:");
            String password = SCANNER.nextLine();

            LoginController loginController = new LoginController();

            try {
                    User user = loginController. (login, password);
                MainMenu.run(user);
                return;
            } catch (LoginException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Do you want to try again?");
                System.out.println("1 - yes");
                System.out.println("2 - no");
                System.out.println("3 - registration");
                int answer = SCANNER.nextInt();

                if (answer == 1) {
                    // do nothing
                    System.out.println("Ok,then let's try again");
                    LoginView.run();
                    break;
                } else if (answer == 2) {
                    break;
                } else if (answer == 3) {
                    RegisterView.run();
                    break;
                } else {
                    throw new IllegalArgumentException("Unsupported operation: " + answer);
                }
            }
        }
    }
}
