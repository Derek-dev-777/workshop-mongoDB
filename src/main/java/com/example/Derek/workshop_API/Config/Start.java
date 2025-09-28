package com.example.Derek.workshop_API.Config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.Derek.workshop_API.Models.DTOs.PostDTO.PostAuthorGetDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		PostEntity post1 = new PostEntity(null, LocalDateTime.now(), "Partiu viagem!", "Vou viajar para sp amanhã", new PostAuthorGetDTO(maria.getId(), maria.getName()));
		PostEntity post2 = new PostEntity(null, LocalDateTime.now(), "Partiu treinar", "Vou treinar mais tarde", new PostAuthorGetDTO(maria.getId(), maria.getName()));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
