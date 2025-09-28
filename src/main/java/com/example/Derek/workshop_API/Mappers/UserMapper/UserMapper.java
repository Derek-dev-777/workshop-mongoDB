package com.example.Derek.workshop_API.Mappers.UserMapper;

import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserPostDTO;
import com.example.Derek.workshop_API.Models.Entities.UserEntity;

public class UserMapper {
	
	public static UserGetDTO convertEntityToDTO(UserEntity entity) {
		return new UserGetDTO(entity.getId(), entity.getName(), entity.getEmail());
	}
	
	public static UserEntity convertDTOtoEntity(UserPostDTO dto) {
		return new UserEntity(dto.getId(), dto.getName(), dto.getEmail());
	}

}
