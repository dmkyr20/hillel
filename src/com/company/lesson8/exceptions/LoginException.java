package com.company.lesson8.exceptions;

public class LoginException extends Throwable {

    public static final String MESSAGE_INVALID_LOGIN = "User with this login is not found";
    public static final String MESSAGE_INVALID_PASS = "Invalid pass";

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
