package com.project.entryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntryDTO {

private String MovieName;
	
	private double rating;
	
	private int duration;
}
