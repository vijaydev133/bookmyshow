package com.project.service;

import com.project.entryDTOs.MovieEntryDTO;
import com.project.responseDTOs.MovieResponseDTO;

public interface IMovieService {

	String addMovie(MovieEntryDTO movieDTO);
	
	Iterable<MovieResponseDTO> getALlMovie();
}
