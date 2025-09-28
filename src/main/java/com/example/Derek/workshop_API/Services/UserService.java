package com.example.Derek.workshop_API.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.workshop_API.Mappers.UserMapper.UserMapper;
import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserPostDTO;
import com.example.Derek.workshop_API.Repositories.UserRepository;
import com.example.Derek.workshop_API.Services.Exceptions.ObjectNotFoundException;

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
	
	public UserGetDTO findUserById(String id) {
		UserEntity userFound = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
		UserGetDTO userToReturn = UserMapper.convertEntityToDTO(userFound);
		return userToReturn;
	}
	
	public UserGetDTO createNewUser(UserPostDTO dto) {
		UserEntity userCreated = UserMapper.convertDTOtoEntity(dto);
		
		userRepository.save(userCreated);
		
		UserGetDTO userToReturn = UserMapper.convertEntityToDTO(userCreated);
		return userToReturn;
	}
	
	public void deleteUserById(String id) {
		UserEntity userFound = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		userRepository.deleteById(userFound.getId());
		
	}
}
