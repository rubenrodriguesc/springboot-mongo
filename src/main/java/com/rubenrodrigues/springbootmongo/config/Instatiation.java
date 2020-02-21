package com.rubenrodrigues.springbootmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rubenrodrigues.springbootmongo.domain.Post;
import com.rubenrodrigues.springbootmongo.domain.User;
import com.rubenrodrigues.springbootmongo.repositories.PostRepository;
import com.rubenrodrigues.springbootmongo.repositories.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail");
		User alex = new User(null, "Alex Green", "alex@gmail");
		User bob = new User(null, "Bob Grey", "bob@gmail");
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T00:00:00.0Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, Instant.parse("2018-03-23T00:00:00.0Z"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
