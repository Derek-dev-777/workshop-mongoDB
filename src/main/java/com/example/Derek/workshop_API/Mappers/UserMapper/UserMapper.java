package com.example.Derek.workshop_API.Mappers.UserMapper;

import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserPostDTO;

public class UserMapper {
	
	public static UserGetDTO convertEntityToDTO(UserEntity entity) {
		return new UserGetDTO(entity.getId(), entity.getName(), entity.getEmail());
	}
	
	public static UserEntity convertDTOtoEntity(UserPostDTO dto) {
		return new UserEntity(dto.getId(), dto.getName(), dto.getEmail());
	}

}
