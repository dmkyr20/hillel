package com.company.lesson8.views;

import com.company.lesson8.models.User;

public class MainMenu {
    public static void run(User user) {
        System.out.println("Hello: " + user.getLogin());
    }
}
