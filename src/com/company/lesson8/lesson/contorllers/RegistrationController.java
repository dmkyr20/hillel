package com.company.lesson8.lesson.contorllers;

import com.company.lesson8.lesson.exceptions.CreateException;
import com.company.lesson8.lesson.exceptions.RegistrationException;
import com.company.lesson8.lesson.models.User;
import com.company.lesson8.lesson.repositories.UserRepository;
import com.company.lesson8.lesson.exceptions.NotFoundException;

public class RegistrationController {
    private final UserRepository repository = new UserRepository();

    private boolean isPasswordValid(String password1, String password2) {
        return password1.equals(password2);
    }

    private boolean isLoginValid(String login) {
        try {
            repository.getUserByLogin(login);
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }

    public User register(String login, String password, String repeatedPassword) throws RegistrationException {
        if (isLoginValid(login)) {
            if (isPasswordValid(password, repeatedPassword)) {
                User user = new User(login, password);
                try {
                    repository.createUser(user);
                    return repository.getUserByLogin(login);
                } catch (CreateException | NotFoundException exception) {
                    throw new RuntimeException(exception);
                }
            } else {
                throw new RegistrationException(RegistrationException.MESSAGE_INVALID_PASS);
            }
        } else {
            throw new RegistrationException(RegistrationException.MESSAGE_INVALID_LOGIN);
        }
    }
}
