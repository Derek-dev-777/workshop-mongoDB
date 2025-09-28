package com.example.Derek.workshop_API.Models.DTOs.PostDTO;

public class PostAuthorGetDTO {
	
	private String id;
	private String name;
	
	public PostAuthorGetDTO() {}

	public PostAuthorGetDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() { return id; }
	public String getName() { return name; }
	
}
