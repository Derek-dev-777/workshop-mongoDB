package com.example.Derek.workshop_API.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.workshop_API.Mappers.PostMapper.PostMapper;
import com.example.Derek.workshop_API.Models.DTOs.PostDTO.PostGetDTO;
import com.example.Derek.workshop_API.Models.Entities.PostEntity;
import com.example.Derek.workshop_API.Repositories.PostRepository;
import com.example.Derek.workshop_API.Services.ServiceExceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	public PostRepository postRepository;
	
	public PostGetDTO findPostById(String postId) {
		PostEntity postToConvert = postRepository.findById(postId).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		PostGetDTO postToReturn = PostMapper.convertEntityToDTO(postToConvert);
		return postToReturn;
	}
}
