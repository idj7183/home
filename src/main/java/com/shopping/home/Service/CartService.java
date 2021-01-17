package com.shopping.home.Service;

import com.shopping.home.Dto.CartResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    @Transactional
    public List show(String cart){

        List<CartResponseDto> cart_goods = new ArrayList<>();

        String[] goods = cart.split("/");

        Long cnt = 0L;

        for(String s:goods){
            String[] tmp= s.split("=");

            cart_goods.add(CartResponseDto.builder().id(cnt++).name(tmp[0]).amount(tmp[1]).build());
        }

        return cart_goods;
    }

}
