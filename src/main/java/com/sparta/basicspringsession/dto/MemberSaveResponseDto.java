package com.sparta.basicspringsession.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class MemberSaveResponseDto {

    private final String name;

    public MemberSaveResponseDto(String name) {
        this.name = name;
    }
}
