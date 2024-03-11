package com.project.responseDTOs;

import java.util.List;

import com.project.models.TicketEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {

	private int id;
	
	private String name;
	
	private int age;
	
	private String email;
	
	private long mobileNumber;
	
	private String address;
	
//	private List<E>
	private List<TicketResponseDTO> tickets;
}
