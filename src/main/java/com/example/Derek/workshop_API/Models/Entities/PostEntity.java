package com.example.Derek.workshop_API.Models.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PostEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private LocalDateTime createdAt;
	private String title;
	private String body;
	private UserEntity author;
	
	public PostEntity() {}

	public PostEntity(String id, LocalDateTime createdAt, String title, String body, UserEntity author) {
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
	public UserEntity getAuthor() { return author; }
	
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(UserEntity author) { this.author = author; }
	public void setBody(String body) { this.body = body; }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostEntity other = (PostEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
