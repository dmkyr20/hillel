package com.company.lesson8.lesson.test;

import com.company.lesson8.lesson.models.User;

public class UserTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        User user1 = new User("", "");
        String test = "test";

        System.out.println(user1.equals(test));
    }
}
