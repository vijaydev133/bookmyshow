package com.project.service;

import com.project.entryDTOs.ShowEntryDTO;
import com.project.responseDTOs.ShowResponseDTO;

public interface IShowSevice {

	String addShow(ShowEntryDTO showDTO);
	
	Iterable<ShowResponseDTO> getAllShow();
}
