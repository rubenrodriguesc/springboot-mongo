package com.rubenrodrigues.springbootmongo.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rubenrodrigues.springbootmongo.domain.Post;
import com.rubenrodrigues.springbootmongo.domain.User;
import com.rubenrodrigues.springbootmongo.dto.AuthorDTO;
import com.rubenrodrigues.springbootmongo.dto.CommentDTO;
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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		ZoneId zone = ZoneId.of("GMT");

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail");
		User alex = new User(null, "Alex Green", "alex@gmail");
		User bob = new User(null, "Bob Grey", "bob@gmail");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, LocalDateTime.parse("2018-03-21T00:00", formatter).atZone(zone).toInstant(),
				"Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDateTime.parse("2018-03-23T00:00", formatter).atZone(zone).toInstant(),
				"Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!",
				LocalDateTime.parse("2018-03-21T00:00", formatter).atZone(zone).toInstant(), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite",
				LocalDateTime.parse("2018-03-22T00:00", formatter).atZone(zone).toInstant(), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!",
				LocalDateTime.parse("2018-03-23T00:00", formatter).atZone(zone).toInstant(), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
