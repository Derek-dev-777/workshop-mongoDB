package com.example.Derek.workshop_API.Models.DTOs.UserDTO;

public class UserGetDTO {
	
	private String id;
	private String name;
	private String email;
	
	public UserGetDTO() {}

	
	public UserGetDTO(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getId() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	
	
	
}
