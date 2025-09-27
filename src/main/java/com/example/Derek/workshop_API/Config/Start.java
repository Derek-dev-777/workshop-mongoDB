package com.example.Derek.workshop_API.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Repositories.UserRepository;

@Configuration
public class Start implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
		UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
		UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}
}
