package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDTOs.UserEntryDTO;
import com.project.responseDTOs.UserResponseDTO;
import com.project.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserEntryDTO userDTO){
		String msg = userService.addUser(userDTO);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<UserResponseDTO>> getAllUser(){
		Iterable<UserResponseDTO> userList = userService.getAllUser();
		return new ResponseEntity<Iterable<UserResponseDTO>>(userList,HttpStatus.ACCEPTED);
	}
}
