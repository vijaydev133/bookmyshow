package com.project.entryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntryDTO {

private String name;
	
	private int age;
	
	private String email;
	
	private long mobileNumber;
	
	private String address;
}
