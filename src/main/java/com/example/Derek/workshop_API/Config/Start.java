package com.example.Derek.workshop_API.Config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.Derek.workshop_API.Models.DTOs.PostDTO.AuthorGetDTO;
import com.example.Derek.workshop_API.Models.DTOs.PostDTO.CommentGetDTO;
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
		
		PostEntity post1 = new PostEntity(null, LocalDateTime.now(), "Partiu viagem!", "Vou viajar para sp amanhã", new AuthorGetDTO(maria.getId(), maria.getName()));
		PostEntity post2 = new PostEntity(null, LocalDateTime.now(), "Partiu treinar", "Vou treinar mais tarde", new AuthorGetDTO(maria.getId(), maria.getName()));
		
		CommentGetDTO c1 = new CommentGetDTO("Boa viagem men", LocalDateTime.now(), new AuthorGetDTO(alex.getId(), alex.getName()));
		CommentGetDTO c2 = new CommentGetDTO("Boa viagem amiga", LocalDateTime.now(), new AuthorGetDTO(alex.getId(), alex.getName()));
		CommentGetDTO c3 = new CommentGetDTO("Bom treino xuxu", LocalDateTime.now(), new AuthorGetDTO(bob.getId(), bob.getName()));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
