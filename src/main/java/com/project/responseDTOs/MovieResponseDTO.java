package com.project.responseDTOs;

import java.util.List;

import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.models.ShowEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDTO {

private int movieId;
	
	private String MovieName;
	
	private double rating;
	
	private int duration;
	
	
	private Language language;
	
	private Genre genre;
	
	private List<ShowResponseDTO> shows;
}
