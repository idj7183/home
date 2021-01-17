package com.shopping.home.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    private String name;

    @Builder
    public UserRequestDto(String name) {
        this.name = name;
    }
}
