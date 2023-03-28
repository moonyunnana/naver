package me.yuna.naver.domain.valueobject;

import me.yuna.naver.exception.PasswordFormatException;
import me.yuna.naver.exception.PasswordNullOrEmptyException;

public class Password {

    private final String password;

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$\n";

    private Password(String password) {
        this.password = password;
    }

    public static Password from(String password) {
        validateNullOrEmpty(password);
        validateFormat(password);

        return new Password(password);
    }

    private static void validateNullOrEmpty(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new PasswordNullOrEmptyException();
        }
    }

    private static void validateFormat(String password) {
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new PasswordFormatException();
        }
    }
}
