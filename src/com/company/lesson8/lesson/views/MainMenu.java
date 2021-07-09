package com.company.lesson8.lesson.views;

import com.company.lesson8.lesson.models.User;

public class MainMenu {
    public static void run(User user) {
        System.out.println("Hello: " + user.getLogin());
    }
}
