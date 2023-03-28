package me.yuna.naver.domain.valueobject;

import me.yuna.naver.exception.PasswordFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("[Unit] Password - value object")
class PasswordTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @DisplayName("[객체 생성 - 실패] 비밀번호 양식을 지키지 않고 패스워드 객체를 생성할 때 예외를 반환")
    void givenPassword_whenCreatePassword_thenThrowException(String password) {
        // given & when
        Throwable throwable = catchThrowable(() -> Password.from(password));

        // then
        assertThat(throwable).isInstanceOf(PasswordFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @DisplayName("[객체 생성 - 성공] 패스워드 객체 생성")
    void givenValidPasswordString_whenCreatePasswordPOJO_thenReturnPasswordPOJO(String password) {
        // given & when

        // then
    }

}