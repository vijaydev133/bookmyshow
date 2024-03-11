package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IMovieDao;
import com.project.entryDTOs.MovieEntryDTO;
import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.enums.SeatType;
import com.project.models.MovieEntity;
import com.project.models.ShowEntity;
import com.project.models.ShowSeatEntity;
import com.project.responseDTOs.MovieResponseDTO;
import com.project.responseDTOs.ShowResponseDTO;

@Service
public class MovieServiceImpl implements IMovieService {
	
	@Autowired
	private IMovieDao movieDao;

	@Override
	public String addMovie(MovieEntryDTO movieDTO) {
		// TODO Auto-generated method stub
		MovieEntity movieEntity = MovieEntity.builder()
				.MovieName(movieDTO.getMovieName())
				.rating(movieDTO.getRating())
				.duration(movieDTO.getDuration())
				.language(Language.ENGLISH)
				.genre(Genre.ACTION)
				.build();
		
		return movieDao.save(movieEntity).getMovieId()+" added success";
	}

	@Override
	public Iterable<MovieResponseDTO> getALlMovie() {
		// TODO Auto-generated method stub
		List<MovieResponseDTO> moviesDTO = new ArrayList<>();
		Iterable<MovieEntity> movieList = movieDao.findAll();
		
		for(MovieEntity movie: movieList) {
//			ShowResponseDTO showDTO = ShowResponseDTO.builder()
//					.id
//					.build();
			List<ShowResponseDTO> showDTOList = new ArrayList<>();
			for(ShowEntity show: movie.getShows()) {
				 List<ShowSeatEntity> showSeats = show.getShowSeats();
				 
				 int premiumSeats=0;
				 int classicSeats=0;
				 for(ShowSeatEntity showSeat: showSeats) {
					 if(showSeat.getSeatType()==SeatType.CLASSIC) {
						 classicSeats++;
					 }else {
						 premiumSeats++;
					 }
				 }
				ShowResponseDTO showResDTO = ShowResponseDTO.builder()
						.id(show.getId())
						.showDate(show.getShowDate())
						.showTime(show.getShowTime())
						.showType(show.getShowType())
						.createdOn(show.getCreatedOn())
						.updatedOn(show.getUpdatedOn())
						.premiumSeats(premiumSeats)
						.classicSeats(classicSeats)
//						.premiumAvailableSeats(show.getShowSeats())
						.build();
				
				showDTOList.add(showResDTO);
			}
			MovieResponseDTO movieDTO = MovieResponseDTO.builder()
					.movieId(movie.getMovieId())
					.MovieName(movie.getMovieName())
					.rating(movie.getRating())
					.duration(movie.getDuration())
					.language(movie.getLanguage())
					.genre(movie.getGenre())
					.shows(showDTOList)
					.build();
			moviesDTO.add(movieDTO);
		}
		return moviesDTO;
	}

}
