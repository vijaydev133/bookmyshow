package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDTOs.ShowEntryDTO;
import com.project.service.IShowSevice;

@RestController
@RequestMapping("show")
public class ShowController {

	@Autowired
	private IShowSevice showService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addShow(@RequestBody ShowEntryDTO showDTO){
		String msg = showService.addShow(showDTO);
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
