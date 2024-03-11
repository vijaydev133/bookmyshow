package com.project.responseDTOs;


import com.project.enums.SeatType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreSeatsResponseDTO {

private int id;
	
	
	private SeatType seatType;

	private String seatNo;
}
