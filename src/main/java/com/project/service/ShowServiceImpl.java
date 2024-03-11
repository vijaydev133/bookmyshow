package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IMovieDao;
import com.project.dao.IShowDao;
import com.project.dao.ITheatreDao;
import com.project.entryDTOs.ShowEntryDTO;
import com.project.enums.SeatType;
import com.project.enums.ShowType;
import com.project.models.MovieEntity;
import com.project.models.ShowEntity;
import com.project.models.ShowSeatEntity;
import com.project.models.TheatreEntity;
import com.project.models.TheatreSeatEntity;
import com.project.responseDTOs.ShowResponseDTO;

@Service
public class ShowServiceImpl implements IShowSevice {

	@Autowired
	private ITheatreDao theatreDao;
	
	@Autowired
	private IMovieDao movieDao;
	@Autowired
	private IShowDao showDao;
	@Override
	public String addShow(ShowEntryDTO showEntryDTO) {
		// TODO Auto-generated method stub
		ShowEntity showEntity = ShowEntity.builder()
				.showTime(showEntryDTO.getShowTime())
				.showDate(showEntryDTO.getShowDate())
				.showType(ShowType._2D)
				.build();
		TheatreEntity theatre = theatreDao.findById(showEntryDTO.getTheatreId()).get() ;
		
		MovieEntity movie = movieDao.findById(showEntryDTO.getMovieId()).get();
		
		showEntity.setMovie(movie);
		showEntity.setTheatre(theatre);
		
		List<ShowSeatEntity> showSeats = createShowSeats(showEntryDTO,showEntity);
		showEntity.setShowSeats(showSeats);
		
		showEntity = showDao.save(showEntity);
		
		theatre.getShows().add(showEntity);
		movie.getShows().add(showEntity);
		
		
		theatreDao.save(theatre);
		movieDao.save(movie);
		return "Show seat saved success";
		
//		return null;
	}

	private List<ShowSeatEntity> createShowSeats(ShowEntryDTO showEntryDTO, ShowEntity showEntity) {
	List<ShowSeatEntity> showSeats = new ArrayList<>();
		
		List<TheatreSeatEntity> theatreSeats = showEntity.getTheatre().getTheatreSeats();
		
		for(TheatreSeatEntity i:theatreSeats) {
			ShowSeatEntity showSeat = ShowSeatEntity.builder()
					.seatNo(i.getSeatNo())
					.seatType(i.getSeatType())
//					.seatType(EnumType.valueOf(i.getSeatType()))
					.showEntity(showEntity)
					.build();
			
			if(i.getSeatType()==SeatType.CLASSIC) {
				showSeat.setPrice(showEntryDTO.getClassicCost());
			}else {
				showSeat.setPrice(showEntryDTO.getPremiumCost());
			}
			
			showSeats.add(showSeat);
			
			
			
		}
		
		return showSeats;
	}

	@Override
	public Iterable<ShowResponseDTO> getAllShow() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
