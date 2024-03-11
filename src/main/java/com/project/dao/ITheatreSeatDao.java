package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.TheatreSeatEntity;

public interface ITheatreSeatDao extends JpaRepository<TheatreSeatEntity, Integer> {

}
