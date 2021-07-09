package com.company.lesson8.lesson.models;

public class User {
    protected String login;
    protected String pass;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof User)) {
            return false;
        }

        User objUser = (User) obj;
        boolean isLoginSame = login.equals(objUser.login);
        boolean isPassSame = pass.equals(objUser.pass);

        return isLoginSame && isPassSame;
    }
}
