package com.sparta.memberTest.controller;

import com.sparta.memberTest.dto.*;
import com.sparta.memberTest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @PutMapping("/members/{memberId}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(memberId, requestDto);
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
