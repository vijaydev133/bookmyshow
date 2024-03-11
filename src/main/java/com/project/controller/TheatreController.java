package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDTOs.TheatreEntryDTO;
import com.project.responseDTOs.TheatreResponseDTO;
import com.project.service.ITheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	private ITheatreService theatreService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDTO theatreDTO){
		String msg = theatreService.addTheatre(theatreDTO);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<TheatreResponseDTO>> getAllTheatre(){
		Iterable<TheatreResponseDTO> theatres = theatreService.getAll();
		
		return new ResponseEntity<Iterable<TheatreResponseDTO>>(theatres,HttpStatus.ACCEPTED);
	}
}
