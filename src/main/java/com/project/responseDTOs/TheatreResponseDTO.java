package com.project.responseDTOs;

import java.util.List;

import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.models.ShowEntity;
import com.project.models.TheatreSeatEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreResponseDTO {

private int id;
	
	private String name;
	
	private String location;
	
	private List<TheatreSeatsResponseDTO> theatreSeats;
}
