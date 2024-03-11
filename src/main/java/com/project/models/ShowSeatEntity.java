package com.project.models;


import java.util.Date;

import com.project.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean isBooked;
	
	private int price;
	
	private String seatNo;
	
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	
	private Date bookeadAt;
	
	
	@ManyToOne
	@JoinColumn
	private ShowEntity showEntity;
}
