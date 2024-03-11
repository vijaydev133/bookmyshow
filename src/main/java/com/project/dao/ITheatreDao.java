package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.TheatreEntity;

public interface ITheatreDao extends JpaRepository<TheatreEntity, Integer> {

}
