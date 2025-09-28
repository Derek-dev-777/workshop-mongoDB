package com.example.Derek.workshop_API.Models.DTOs.PostDTO;

import java.time.LocalDateTime;

public class PostGetDTO {
	
	private String id;
	private LocalDateTime createdAt;
	private String title;
	private String body;
	private PostAuthorGetDTO author;
	
	public PostGetDTO() {}

	public PostGetDTO(String id, LocalDateTime createdAt, String title, String body, PostAuthorGetDTO author) {
		this.id = id;
		this.createdAt = createdAt;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() { return id; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public String getTitle() { return title; }
	public String getBody() { return body; }
	public PostAuthorGetDTO getAuthor() { return author; }
}
