package com.company.lesson8.lesson.views;

import java.util.Scanner;

public class StartMenu {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void run() {
        System.out.println("Hello!");
        System.out.println("Do you have an account?");
        System.out.println("1 - yes");
        System.out.println("2 - no");

        int answer = SCANNER.nextInt();

        if (answer == 1) {
            LoginView.run();
        } else if (answer == 2) {
            RegisterView.run();
        }
    }
}
