package com.rubenrodrigues.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubenrodrigues.springbootmongo.domain.User;
import com.rubenrodrigues.springbootmongo.repositories.UserRepository;
import com.rubenrodrigues.springbootmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
