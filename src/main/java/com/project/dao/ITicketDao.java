package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.TicketEntity;

public interface ITicketDao extends JpaRepository<TicketEntity, Integer> {

}
