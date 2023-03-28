package me.yuna.naver.domain.valueobject;

import me.yuna.naver.exception.EmailNullOrEmptyException;
import me.yuna.naver.exception.EmailFormatException;

public class Email {

    private final String email;

    private static final String EMAIL_FORMAT = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    private Email(String email) {
        this.email = email;
    }

    public static Email from(String email) {
        validateNullOrEmpty(email);
        validateFormat(email);

        return new Email(email);
    }

    private static void validateNullOrEmpty(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new EmailNullOrEmptyException();
        }
    }

    private static void validateFormat(String email) {
        if (!email.matches(EMAIL_FORMAT)) {
            throw new EmailFormatException();
        }
    }
}
