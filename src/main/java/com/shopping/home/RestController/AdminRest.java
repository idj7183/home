package com.shopping.home.RestController;

import com.shopping.home.Domain.User.User;
import com.shopping.home.Dto.UserRequestDto;
import com.shopping.home.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminRest {

    private final UserService userService;

    @PostMapping("/admin/user")
    public User change(@RequestBody UserRequestDto requestDto){

        return userService.findByName(requestDto.getName());
    }

}
