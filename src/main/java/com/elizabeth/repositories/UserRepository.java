package com.elizabeth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elizabeth.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public List<User> findAllByReceivesNotifications(boolean receivesNotifications);
}
