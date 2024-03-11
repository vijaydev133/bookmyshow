package com.project.models;

import java.util.List;

import com.project.enums.Genre;
import com.project.enums.Language;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	private String MovieName;
	
	private double rating;
	
	private int duration;
	
	@Enumerated(EnumType.STRING)
	private Language language;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
	private List<ShowEntity> shows;
}
