package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDTOs.MovieEntryDTO;
import com.project.responseDTOs.MovieResponseDTO;
import com.project.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class movieController {

	@Autowired
	private IMovieService movieService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addMovie(@RequestBody MovieEntryDTO movieDTO){
		String msg = movieService.addMovie(movieDTO);
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<MovieResponseDTO>> getAllMovie(){
		Iterable<MovieResponseDTO> movieList = movieService.getALlMovie();
		return new ResponseEntity<Iterable<MovieResponseDTO>>(movieList,HttpStatus.ACCEPTED);
	}
}
