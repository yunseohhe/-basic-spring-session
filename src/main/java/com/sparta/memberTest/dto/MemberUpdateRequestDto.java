package com.sparta.memberTest.dto;

import lombok.Getter;

@Getter
public class MemberUpdateRequestDto {

    private String name;

    public MemberUpdateRequestDto(String name) {
        this.name = name;
    }
}
