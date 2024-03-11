package com.project.entryDTOs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntryDTO {

	private int showId;
	
	private List<String> requestedSeats;
	
	private int userId;
}
