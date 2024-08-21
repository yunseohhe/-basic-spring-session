package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public MemberSaveResponseDto saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        return memberService.saveMember(memberSaveRequestDto);
    }

    @GetMapping("/members")
    public List<MemberSimpleResponseDto> getMembers() {
        return memberService.getMembers();
    }

}
