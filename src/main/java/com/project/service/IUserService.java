package com.project.service;

import com.project.entryDTOs.UserEntryDTO;
import com.project.responseDTOs.UserResponseDTO;

public interface IUserService {

	String addUser(UserEntryDTO userDto);
	
	Iterable<UserResponseDTO> getAllUser();
}
