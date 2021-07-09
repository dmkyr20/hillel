package com.company.lesson8.lesson.test;

import com.company.lesson8.lesson.exceptions.CreateException;
import com.company.lesson8.lesson.models.User;
import com.company.lesson8.lesson.repositories.UserRepository;

public class RepositoryTest {

    public static void main(String[] args) throws CreateException {
        test1();
        test2();
    }

    public static void test1() throws CreateException {
        User user1 = new User("test", "test");

        UserRepository userRepository = new UserRepository();// UserRepository.instance();

        userRepository.createUser(user1);
        userRepository.createUser(user1);
    }

    public static void test2() throws CreateException {
        User user1 = new User("test", "test");
        User user2 = new User("test", "test");

        UserRepository repository = new UserRepository(); //UserRepository.instance();

        repository.createUser(user1);
        repository.createUser(user2);
    }
}
