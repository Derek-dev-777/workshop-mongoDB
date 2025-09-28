package com.example.Derek.workshop_API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.workshop_API.Models.Entities.DTOs.UserDTO.UserGetDTO;
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
}
