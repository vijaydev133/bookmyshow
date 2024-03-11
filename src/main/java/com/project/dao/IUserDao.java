package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.UserEntity;

public interface IUserDao extends JpaRepository<UserEntity, Integer> {

}
