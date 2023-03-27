package me.yuna.naver.unit;

import me.yuna.naver.domain.Member;
import me.yuna.naver.exception.EmailCanNotBeNullOrEmptyException;
import me.yuna.naver.exception.PasswordCanNotBeNullOrEmptyException;
import me.yuna.naver.exception.WrongEmailFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("[단위 테스트] 멤버 도메인")
public class MemberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("[객체 생성 - 실패] 공백 이메일을 멤버 객체 생성할 때 사용하면 예외를 반환")
    void givenNullAndEmptyEmail_whenCreateMember_thenThrowException(String email) {
        // given & when
        Throwable throwable = catchThrowable(() -> Member.create(email, "password"));

        // then
        assertThat(throwable).isInstanceOf(EmailCanNotBeNullOrEmptyException.class);
    }

    @ParameterizedTest(name = "password=[{0}]")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("[객체 생성 - 실패] 공백 패스워드를 멤버 객체 생성할 때 사용하면 예외를 반환")
    void givenNullAndEmptyPassword_whenCreateMember_thenThrowException(String password) {
        // given & when
        Throwable throwable = catchThrowable(() -> Member.create("test@email.com", password));

        // then
        assertThat(throwable).isInstanceOf(PasswordCanNotBeNullOrEmptyException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "test.email.com"})
    @DisplayName("[객체 생성 - 실패] 올바르지 않은 이메일 형식을 멤버 객체 생성할 때 사용하면 예외를 반환")
    void givenWrongEmailFormat_whenCreateMember_thenThrowException(String email) {
        // given & when
        Throwable throwable = catchThrowable(() -> Member.create(email, "password"));

        // then
        assertThat(throwable).isInstanceOf(WrongEmailFormatException.class);
    }
}