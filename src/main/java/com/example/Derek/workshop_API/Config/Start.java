package com.example.Derek.workshop_API.Config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.Derek.workshop_API.Models.Entities.PostEntity;
import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Repositories.PostRepository;
import com.example.Derek.workshop_API.Repositories.UserRepository;

@Configuration
public class Start implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
		UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
		UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
		
		PostEntity post1 = new PostEntity(null, LocalDateTime.now(), "Partiu viagem!", "Vou viajar para sp amanhã", maria);
		PostEntity post2 = new PostEntity(null, LocalDateTime.now(), "Partiu treinar", "Vou treinar mais tarde", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));

	}
}
