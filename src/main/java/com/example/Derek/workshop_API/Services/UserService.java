package com.example.Derek.workshop_API.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.workshop_API.Mappers.PostMapper.PostMapper;
import com.example.Derek.workshop_API.Mappers.UserMapper.UserMapper;
import com.example.Derek.workshop_API.Models.DTOs.PostDTO.PostGetDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserPostDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserPutDTO;
import com.example.Derek.workshop_API.Models.Entities.PostEntity;
import com.example.Derek.workshop_API.Models.Entities.UserEntity;
import com.example.Derek.workshop_API.Repositories.UserRepository;
import com.example.Derek.workshop_API.Services.ServiceExceptions.ObjectNotFoundException;

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
		UserEntity userFound = getUserEntityByIdOrThrowException(id);
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
		UserEntity userFound = getUserEntityByIdOrThrowException(id);
		userRepository.deleteById(userFound.getId());
	}
	
	public UserGetDTO updateUserByID(String id, UserPutDTO dto) {
		UserEntity userFound = getUserEntityByIdOrThrowException(id);
		updateUserDataAndSave(userFound, dto);
		
		UserGetDTO userToReturn = UserMapper.convertEntityToDTO(userFound);
		return userToReturn;
	}
	
	public List<PostGetDTO> findUserPosts(String id) {
		UserEntity userFound = getUserEntityByIdOrThrowException(id);
		List<PostEntity> listToConvert = userFound.getPosts();
		List<PostGetDTO> listToReturn = new ArrayList<>();
		
		for(PostEntity x : listToConvert) {
			listToReturn.add(PostMapper.convertEntityToDTO(x));
		}
		
		return listToReturn;
	}
	
	public UserEntity getUserEntityByIdOrThrowException(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public void updateUserDataAndSave(UserEntity entity, UserPutDTO dto) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
		userRepository.save(entity);
	}
	
	
	
}
