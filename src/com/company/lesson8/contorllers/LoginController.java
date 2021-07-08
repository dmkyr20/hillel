package com.company.lesson8.contorllers;

import com.company.lesson8.exceptions.LoginException;
import com.company.lesson8.exceptions.NotFoundException;
import com.company.lesson8.models.User;
import com.company.lesson8.repositories.UserRepository;

public class LoginController {

    private final UserRepository repository = new UserRepository();
//
//    public User login(String login) {
//        // if repo contains user with login
//    }

    private boolean isLoginValid(String login) {
        try {
            repository.getUserByLogin(login);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
    private boolean isPasswordValid(String login, String password) {
        try {
            String pass = repository.getUserByLogin(login).getPass();
                return pass.equals(password);
        } catch (NotFoundException e) {
            return true;
        }
    }

    public User login(String login, String password) throws LoginException {
        if (isLoginValid(login)) {
            if (isPasswordValid(login, password)) {
                try {
                    return repository.getUserByLogin(login);
                } catch (NotFoundException exception) {
                    throw new RuntimeException(exception);
//                    throw new NotFoundException("User with login:" + login + " not found");
                }
            } else {
                throw new LoginException(LoginException.MESSAGE_INVALID_PASS);
            }
        } else {
            throw new LoginException(LoginException.MESSAGE_INVALID_LOGIN);
        }
    }
}


