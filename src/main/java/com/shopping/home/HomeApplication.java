package com.shopping.home;

import com.shopping.home.Domain.User.User;
import com.shopping.home.Domain.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomeApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HomeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		userRepository.save(User.builder().name("유저1").password("ddd").build());

		User user = User.builder().name("user").password("user1234").build();

		user.update_Role();

		userRepository.save(user);

	}
}
