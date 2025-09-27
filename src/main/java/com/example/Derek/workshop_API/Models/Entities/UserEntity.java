package com.example.Derek.workshop_API.Models.Entities;

import java.io.Serializable;
import java.util.Objects;

public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserEntity() {}

	public UserEntity(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public String getEmail() {return email; }

	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }

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
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
