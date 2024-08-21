package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members") // 추가
    public MemberSaveResponseDto saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        return memberService.saveMember(memberSaveRequestDto);
    }

    @GetMapping("/members") // 추가한 모든 것들을 조회
    public List<MemberSimpleResponseDto> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{memberId}") // 특정 Id 조회
    public MemberDetailResponseDto getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/members/{memberId}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(memberId, requestDto);
    }
}
