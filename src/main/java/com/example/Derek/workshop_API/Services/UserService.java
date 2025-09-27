package com.example.Derek.workshop_API.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.workshop_API.Mappers.UserMapper.UserMapper;
import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserGetDTO> findAllUsers(){
		List<UserEntity> listOfEntity = userRepository.findAll();
		List<UserGetDTO> listToReturn = new ArrayList<>();
		
		for(UserEntity entity : listOfEntity) {
			listToReturn.add(UserMapper.convertEntityToDTO(entity));
		}
		return listToReturn;
	}
	
}
