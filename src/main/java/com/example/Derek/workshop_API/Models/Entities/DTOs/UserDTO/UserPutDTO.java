package com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO;

public class UserPutDTO {
	
	private String name;
	private String email;
	
	public UserPutDTO() {}

	public UserPutDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() { return name; }
	public String getEmail() { return email; }	
}
