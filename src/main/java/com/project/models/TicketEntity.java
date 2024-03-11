package com.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String MovieName;
	
	private int totalAmount;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
//	private LocalDate bookedAt;
	
	private String bookedSeat;
	
	private String ticketId;
	private String	theatreName;
	
	
	@ManyToOne
	@JoinColumn
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn
	private ShowEntity show;
	
	
	
}
