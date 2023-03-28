package me.yuna.naver.service;

import me.yuna.naver.domain.Member;
import me.yuna.naver.exception.NullMemberException;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        if (member == null) {
            throw new NullMemberException();
        }

        memberRepository.save(member);

        return member.getId();
    }
}
