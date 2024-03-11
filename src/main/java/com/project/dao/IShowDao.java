package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.ShowEntity;

public interface IShowDao extends JpaRepository<ShowEntity, Integer> {

}
