package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDTOs.TicketEntryDTO;
import com.project.service.ITicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private ITicketService ticketService;
	
	@PostMapping("/book-ticket")
	public ResponseEntity<String> addTicket(@RequestBody TicketEntryDTO ticketDTO){
		String msg= ticketService.addTicket(ticketDTO);
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
