package com.project.entryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreEntryDTO {
	private String name;
	
	
	private String location;
	
	private int premiumCount;
	
	private int classicCount;
}
