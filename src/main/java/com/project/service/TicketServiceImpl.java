package com.project.service;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.dao.IShowDao;
import com.project.dao.ITicketDao;
import com.project.dao.IUserDao;
import com.project.entryDTOs.TicketEntryDTO;
import com.project.exceptions.NoUserFoundException;
import com.project.exceptions.SeatNotAvailable;
import com.project.exceptions.ShowNotFound;
import com.project.models.ShowEntity;
import com.project.models.ShowSeatEntity;
import com.project.models.TicketEntity;
import com.project.models.UserEntity;


@Service
public class TicketServiceImpl implements ITicketService {

	
	@Autowired
	private ITicketDao ticketDao;
	@Autowired
	private IShowDao showDao;
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private JavaMailSender emailSender;
	
	
	
	@Override
	public String addTicket(TicketEntryDTO ticketDTO) {
		// TODO Auto-generated method stub
		int showId=ticketDTO.getShowId();
		
		ShowEntity showEntity = showDao.findById(showId).get();
		if(showEntity==null) {
			throw new ShowNotFound("show not found");
		}
		String theatreName = showEntity.getTheatre().getName();
//		if(showEntity==null) {
//			throw new ShowNotFound("show not found");
//		}
		List<String> bookedSeats = new ArrayList<String>();
		int totalAmount = calculateAmount(ticketDTO,showEntity,bookedSeats);
		if(totalAmount==-1) {
			throw new SeatNotAvailable("Seat not available, try booking other seat");
		}
		
		TicketEntity ticketEntity = TicketEntity.builder()
				.MovieName(showEntity.getMovie().getMovieName())
				.totalAmount(totalAmount)
				.showDate(showEntity.getShowDate())
				.showTime(showEntity.getShowTime())
//				.bookedAt(LocalDate.now())
//				.bookedSeats(bookedSeats)
				.ticketId(UUID.randomUUID().toString())
				.theatreName(theatreName)
				.build();
		
		
		String temp = "";
		for(String seat: bookedSeats) {
			System.out.println("bookedSeat "+seat);
//			ticketEntity.getBookedSeats().add(seat);
			temp += seat;
		}
		ticketEntity.setBookedSeat(temp);
	   Optional<UserEntity> byId = userDao.findById(ticketDTO.getUserId());
		if(byId.isEmpty()) {
			throw new NoUserFoundException("user not found");
		}
		UserEntity userEntity = byId.get();
		ticketEntity.setUser(userEntity);
		ticketEntity.setShow(showEntity);
		ticketEntity = ticketDao.save(ticketEntity);
		
		userEntity.getTickets().add(ticketEntity);
		showEntity.getTickets().add(ticketEntity);
		
		showDao.save(showEntity);
		userDao.save(userEntity);
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        String body="Hii! "+userEntity.getName()+"\n"+
                "You have successfully booked a ticket. Please find the following details of your ticket \n"+
                "Booked seats "+bookedSeats+"\n"+
                "Movie name "+showEntity.getMovie().getMovieName()+"\n"+
                "Show date is "+showEntity.getShowDate()+"\n"+
                "Show time is "+showEntity.getShowTime()+"\n"+
                "Enjoy the show!!"+"\n"+
                "Thank You";
//        simpleMailMessage.setSubject("Ticket Confirmation Mail");
        simpleMailMessage.setSubject(" Ennapa Ticket Ready , Padathuku Polama");
        simpleMailMessage.setFrom("mailsender082@gmail.com");
        simpleMailMessage.setText(body);
        simpleMailMessage.setTo(userEntity.getEmail());
        emailSender.send(simpleMailMessage);
		
		
		
		return "ticket added successfully";
	}
	private int calculateAmount(TicketEntryDTO ticketDTO, ShowEntity showEntity,List<String> bookedSeats) {
		// TODO Auto-generated method stub
		List<String> requestedSeats = ticketDTO.getRequestedSeats();
		List<ShowSeatEntity> showSeatList = showEntity.getShowSeats();
		int amount = 0;
		System.out.println("came here");
		for(ShowSeatEntity showSeat: showSeatList) {
			System.out.println(showSeat.getSeatNo());
			if(requestedSeats.contains(showSeat.getSeatNo())) {
				if(!showSeat.isBooked()) {
					amount += showSeat.getPrice();
					bookedSeats.add(showSeat.getSeatNo());
					showSeat.setBooked(true);
					showSeat.setBookeadAt(new Date());
					System.out.println("came here");
				}else {
					return -1;
				}
			}
		}
		return amount;
	}

}
