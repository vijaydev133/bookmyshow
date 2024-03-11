package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IUserDao;
import com.project.entryDTOs.UserEntryDTO;
import com.project.models.TicketEntity;
import com.project.models.UserEntity;
import com.project.responseDTOs.TicketResponseDTO;
import com.project.responseDTOs.UserResponseDTO;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public String addUser(UserEntryDTO userDto) {
		// TODO Auto-generated method stub
		UserEntity user = UserEntity.builder()
				.name(userDto.getName())
				.age(userDto.getAge())
				.address(userDto.getAddress())
				.email(userDto.getEmail())
				.mobileNumber(userDto.getMobileNumber())
				.build();
		
		
//		UserEntity save = userDao.save(user);
		return userDao.save(user).getId()+" saved successfully";
	}

	@Override
	public Iterable<UserResponseDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<UserResponseDTO> userDTOList = new ArrayList<>();
		List<UserEntity> userList = userDao.findAll();
		
		for(UserEntity userEntity: userList) {
			List<TicketEntity> ticketList = userEntity.getTickets();
			List<TicketResponseDTO> ticketDTOList = new ArrayList<>();
			for(TicketEntity ticketEntity : ticketList) {
				TicketResponseDTO ticketResDTO = TicketResponseDTO.builder()
						.id(ticketEntity.getId())
						.MovieName(ticketEntity.getMovieName())
						.totalAmount(ticketEntity.getTotalAmount())
						.showDate(ticketEntity.getShowDate())
						.showTime(ticketEntity.getShowTime())
						.ticketId(ticketEntity.getTicketId())
						.theatreName(ticketEntity.getTheatreName())
						.build();
				
				ticketDTOList.add(ticketResDTO);
			}
			
			UserResponseDTO userResDTO = UserResponseDTO.builder()
					.id(userEntity.getId())
					.name(userEntity.getName())
					.age(userEntity.getAge())
					.email(userEntity.getEmail())
					.mobileNumber(userEntity.getMobileNumber())
					.address(userEntity.getAddress())
					.tickets(ticketDTOList)
					.build();
			
			userDTOList.add(userResDTO);
		}
		
		return userDTOList;
	}

}
