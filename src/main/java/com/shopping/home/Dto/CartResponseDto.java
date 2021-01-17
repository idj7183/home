package com.shopping.home.Dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CartResponseDto {

    private Long id;

    private String name;

    private String amount;

    @Builder
    public CartResponseDto(Long id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
