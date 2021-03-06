package com.rubenrodrigues.springbootmongo.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubenrodrigues.springbootmongo.domain.Post;
import com.rubenrodrigues.springbootmongo.repositories.PostRepository;
import com.rubenrodrigues.springbootmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate){	
		maxDate = maxDate.plusSeconds(24*60*60);
		return repository.fullSearch(text, minDate, maxDate);
	}

}
