package com.example.Derek.workshop_API.Models.DTOs.PostDTO;

import java.time.LocalDateTime;
import java.util.List;

public class PostGetDTO {
	
	private String id;
	private LocalDateTime createdAt;
	private String title;
	private String body;
	private AuthorGetDTO author;
	private List<CommentGetDTO> comments;
	
	public PostGetDTO() {}

	public PostGetDTO(String id, LocalDateTime createdAt, String title, String body, AuthorGetDTO author, List<CommentGetDTO> comments) {
		this.id = id;
		this.createdAt = createdAt;
		this.title = title;
		this.body = body;
		this.author = author;
		this.comments = comments;
	}

	public String getId() { return id; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public String getTitle() { return title; }
	public String getBody() { return body; }
	public AuthorGetDTO getAuthor() { return author; }
	public List<CommentGetDTO> getComments() { return comments; }
}
