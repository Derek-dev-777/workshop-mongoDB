package com.example.Derek.workshop_API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.workshop_API.Models.DTOs.PostDTO.PostGetDTO;
import com.example.Derek.workshop_API.Services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	public PostService postService;
	
	@GetMapping("{id}")
	public ResponseEntity<PostGetDTO> findPostById(@PathVariable String id){
		PostGetDTO postFound = postService.findPostById(id);
		return ResponseEntity.ok().body(postFound);
	}
}
