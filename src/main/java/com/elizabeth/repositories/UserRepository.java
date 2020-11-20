package com.elizabeth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elizabeth.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
