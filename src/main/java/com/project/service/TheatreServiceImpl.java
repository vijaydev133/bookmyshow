package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ITheatreDao;
import com.project.entryDTOs.TheatreEntryDTO;
import com.project.enums.SeatType;
import com.project.models.TheatreEntity;
import com.project.models.TheatreSeatEntity;
import com.project.responseDTOs.TheatreResponseDTO;
import com.project.responseDTOs.TheatreSeatsResponseDTO;

@Service
public class TheatreServiceImpl implements ITheatreService {

	
	@Autowired
	private ITheatreDao theatreDao;
	@Override
	public String addTheatre(TheatreEntryDTO theatreDTO) {
		// TODO Auto-generated method stub
		
		
		
		TheatreEntity theatre = TheatreEntity.builder()
				.name(theatreDTO.getName())
				.location(theatreDTO.getLocation())
				.build();
		List<TheatreSeatEntity> theatreSeats = createTheatreSeats(theatreDTO ,theatre);
		theatre.setTheatreSeats(theatreSeats);
		return theatreDao.save(theatre).getId()+ " added successfully";
	}

	private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDTO theatreDTO, TheatreEntity theatre) {
		// TODO Auto-generated method stub
		int premiumCount = theatreDTO.getPremiumCount();
		int classicCount = theatreDTO.getClassicCount();
		List<TheatreSeatEntity> theatreSeats = new ArrayList<>();
		
		for(int i=1; i<=premiumCount; i++) {
			TheatreSeatEntity theatreSeat = TheatreSeatEntity.builder()
					.seatNo(i+"P")
					.seatType(SeatType.PREMIUM)
					.theatre(theatre)
					.build();
			theatreSeats.add(theatreSeat);
		}
		for(int i=1; i<=classicCount; i++) {
			TheatreSeatEntity theatreSeat = TheatreSeatEntity.builder()
					.seatNo(i+"C")
					.seatType(SeatType.CLASSIC)
					.theatre(theatre)
					.build();
			theatreSeats.add(theatreSeat);
		}
		
		return theatreSeats;
	}

	@Override
	public Iterable<TheatreResponseDTO> getAll() {
		// TODO Auto-generated method stub
		Iterable<TheatreEntity> theatres = theatreDao.findAll();
		List<TheatreResponseDTO> theatreResDTO = new ArrayList<>();
		
		for(TheatreEntity theatre: theatres) {
			List<TheatreSeatEntity> theatreSeats = theatre.getTheatreSeats();
			List<TheatreSeatsResponseDTO> theatreSeatsDTO =  new ArrayList<>();
			
			for(TheatreSeatEntity theatreSeat: theatreSeats) {
				TheatreSeatsResponseDTO theatreSeatDTO = TheatreSeatsResponseDTO.builder()
						.id(theatreSeat.getId())
						.seatType(theatreSeat.getSeatType())
						.seatNo(theatreSeat.getSeatNo())
						.build();
				theatreSeatsDTO.add(theatreSeatDTO);
			}
			TheatreResponseDTO theatreDTO = TheatreResponseDTO.builder()
					.id(theatre.getId())
					.name(theatre.getName())
					.location(theatre.getLocation())
					.theatreSeats(theatreSeatsDTO)
					.build();
			theatreResDTO.add(theatreDTO);
//			theatreSeatsDTO.add(theatreDTO);
		}
		return theatreResDTO;
	}

}
