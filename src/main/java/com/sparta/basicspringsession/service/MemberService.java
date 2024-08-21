package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.MemberDetailResponseDto;
import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>();
        for (Member member : members) {
            memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
        }
        return memberSimpleResponseDtos;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));
        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

}
