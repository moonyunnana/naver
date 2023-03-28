package me.yuna.naver.domain;

import me.yuna.naver.domain.valueobject.Email;
import me.yuna.naver.domain.valueobject.Password;

public class Member {

    private Long id;

    private Email email;

    private Password password;

    private Member(String email, String password) {
        this.email = Email.from(email);
        this.password = Password.from(password);
    }

    public static Member create(String email, String password) {
        return new Member(email, password);
    }

    public Long getId() {
        return 1L;
    }
}
