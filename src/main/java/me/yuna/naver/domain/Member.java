package me.yuna.naver.domain;

import me.yuna.naver.exception.EmailCanNotBeNullOrEmptyException;
import me.yuna.naver.exception.PasswordCanNotBeNullOrEmptyException;
import me.yuna.naver.exception.WrongEmailFormatException;

import java.util.regex.Pattern;

public class Member {

    private Long id;

    private String email;

    private String password;

    static final String EMAIL_FORMAT = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    private Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Member create(String email, String password) {
        if (email == null || email.isBlank()) {
            throw new EmailCanNotBeNullOrEmptyException();
        }

        if (password == null || password.isBlank()) {
            throw new PasswordCanNotBeNullOrEmptyException();
        }

        validateEmailFormat(email);

        return new Member(email, password);
    }

    private static void validateEmailFormat(String email) {
        boolean isMatched = Pattern.matches(EMAIL_FORMAT, email);
        if (!isMatched) {
            throw new WrongEmailFormatException();
        }
    }

    public Long getId() {
        return 1L;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
