package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.MovieEntity;

public interface IMovieDao extends JpaRepository<MovieEntity, Integer> {

}
