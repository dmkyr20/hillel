package com.company.lesson8.lesson.repositories;

import com.company.lesson8.lesson.exceptions.CreateException;
import com.company.lesson8.lesson.exceptions.NotFoundException;
import com.company.lesson8.lesson.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final List<User> REPOSITORY = new ArrayList<>();
//    private static final UserRepository USER_REPOSITORY = new UserRepository();
//
//    private UserRepository() {}
//
//    public static UserRepository instance() {
//        return USER_REPOSITORY;
//    }

    public void createUser(User user) throws CreateException {
        if (REPOSITORY.contains(user)) {
            throw new CreateException("User already created");
        }
        REPOSITORY.add(user);
    }

    public User getUserByLogin(String login) throws NotFoundException {
        for(User user : REPOSITORY) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        throw new NotFoundException("User with login:" + login + " not found");
    }
}
