package com.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.enums.ShowType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
	@Enumerated(EnumType.STRING)
	private ShowType showType;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
	
	@OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
	private List<ShowSeatEntity> showSeats;
	
	@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
	private List<TicketEntity> tickets;
	
	
	@ManyToOne
	@JoinColumn
	private MovieEntity movie;
	
	@ManyToOne
	@JoinColumn
	private TheatreEntity theatre;
}
