package com.example.Derek.workshop_API.Models.DTOs.PostDTO;

import java.time.LocalDateTime;

public class CommentGetDTO {
	
	private String text;
	private LocalDateTime createdAt;
	private AuthorGetDTO author;
	
	public CommentGetDTO() {}

	public CommentGetDTO(String text, LocalDateTime createdAt, AuthorGetDTO author) {
		this.text = text;
		this.createdAt = createdAt;
		this.author = author;
	}

	public String getText() { return text; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public AuthorGetDTO getAuthor() { return author; }
}
