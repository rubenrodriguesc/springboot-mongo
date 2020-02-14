package com.rubenrodrigues.springbootmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rubenrodrigues.springbootmongo.domain.User;
import com.rubenrodrigues.springbootmongo.repositories.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail");
		User alex = new User(null, "Alex Green", "alex@gmail");
		User bob = new User(null, "Bob Grey", "bob@gmail");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
