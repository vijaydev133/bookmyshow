package com.project.responseDTOs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.enums.ShowType;
import com.project.models.ShowEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowResponseDTO {

	private int id;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
	private ShowType showType;
	
	private Date createdOn;
	
	int premiumSeats;
	
	int classicSeats;
	
	private Date updatedOn;
}
