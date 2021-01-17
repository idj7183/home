package com.shopping.home.Service;

import com.shopping.home.Domain.User.User;
import com.shopping.home.Domain.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User findByName(String username) {

        User user = userRepository.findByName(username)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다!"));

        user.update_Role();

        return user;
    }

    @Transactional
    public Long count(){

        return userRepository.count();

    }
}
