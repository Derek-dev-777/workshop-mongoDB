package com.example.Derek.workshop_API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserGetDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserPostDTO;
import com.example.Derek.workshop_API.Models.DTOs.UserDTO.UserPutDTO;
import com.example.Derek.workshop_API.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserGetDTO>> findAll(){
		List<UserGetDTO> listToReturn = userService.findAllUsers();
		
		return ResponseEntity.ok().body(listToReturn);
		}

	@GetMapping("/{id}")
	public ResponseEntity<UserGetDTO> findUserByID(@PathVariable String id){
		UserGetDTO userToReturn = userService.findUserById(id);
		return ResponseEntity.ok().body(userToReturn);
	}
	
	@PostMapping
	public ResponseEntity<UserGetDTO> createNewUser(@RequestBody UserPostDTO dto){
		UserGetDTO userToReturn = userService.createNewUser(dto);
		return ResponseEntity.status(201).body(userToReturn);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String id){
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserGetDTO> updateUserById(@PathVariable String id, @RequestBody UserPutDTO dto){
		UserGetDTO userToReturn = userService.updateUserByID(id, dto);
		return ResponseEntity.ok().body(userToReturn);
	}
}
