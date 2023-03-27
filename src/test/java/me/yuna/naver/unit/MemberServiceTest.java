package me.yuna.naver.unit;

import me.yuna.naver.domain.Member;
import me.yuna.naver.exception.NullMemberException;
import me.yuna.naver.service.MemberRepository;
import me.yuna.naver.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("[단위 테스트] 멤버 서비스")
public class MemberServiceTest {

    private final MemberRepository memberRepository = Mockito.mock(MemberRepository.class);

    private final MemberService memberService = new MemberService(memberRepository);

    @ParameterizedTest
    @NullSource
    @DisplayName("[가입 - 실패] 멤버 객체 Null")
    void givenNullMember_whenJoin_thenThrowException(Member member) {
        // given & when
        Throwable throwable = catchThrowable(() -> memberService.join(member));

        // then
        assertThat(throwable).isInstanceOf(NullMemberException.class);
    }

    @Test
    @DisplayName("[가입 - 성공]")
    void givenMember_whenJoin_thenReturnMemberId() {
        // given
        Member member = Member.create("test@email.com", "123456");

        // when
        Long memberId = memberService.join(member);

        // then
        assertThat(memberId).isNotNull();
    }

}
