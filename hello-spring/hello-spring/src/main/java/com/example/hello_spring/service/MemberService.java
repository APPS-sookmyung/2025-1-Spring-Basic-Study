package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;

public class MemberService {
    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        memberRdpository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                })
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() { return memberRepository.findAll();}

    public Optional<Member> findOne(Long memberId) { return memberRepository.findById(memberId);}

}