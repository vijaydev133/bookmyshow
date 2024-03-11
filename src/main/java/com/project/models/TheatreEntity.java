package com.project.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String location;
	
	
	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	private List<TheatreSeatEntity> theatreSeats;
	
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	private List<ShowEntity> shows;
}
