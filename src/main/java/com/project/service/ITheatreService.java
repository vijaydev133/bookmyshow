package com.project.service;

import com.project.entryDTOs.TheatreEntryDTO;
import com.project.responseDTOs.TheatreResponseDTO;

public interface ITheatreService {

	String addTheatre(TheatreEntryDTO theatreDTO);
	
	Iterable<TheatreResponseDTO> getAll();
}
