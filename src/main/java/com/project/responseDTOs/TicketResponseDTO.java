package com.project.responseDTOs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponseDTO {

	private int id;
	
	private String MovieName;
	
	private int totalAmount;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
	private String ticketId;
	
	private String	theatreName;
	
//	private List<E>
}
