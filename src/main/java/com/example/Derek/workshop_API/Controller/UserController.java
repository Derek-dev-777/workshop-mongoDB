package com.example.Derek.workshop_API.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.workshop_API.Models.Entities.UserEntity;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> findAll(){
		UserEntity maria = new UserEntity("1", "Maria", "Maria@gmail");
		UserEntity derek = new UserEntity("2", "Derek", "Derek@gmail");
		List<UserEntity> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, derek));
		return ResponseEntity.ok().body(list);
	}
}
