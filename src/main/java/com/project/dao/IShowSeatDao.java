package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.ShowSeatEntity;

public interface IShowSeatDao extends JpaRepository<ShowSeatEntity, Integer> {

}
