package com.example.Derek.workshop_API.Mappers.UserMapper;

import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserGetDTO;

public class UserMapper {
	
	public static UserGetDTO convertEntityToDTO(UserEntity entity) {
		return new UserGetDTO(entity.getId(), entity.getName(), entity.getEmail());
	}
	

}
