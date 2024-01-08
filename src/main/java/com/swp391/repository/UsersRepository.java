package com.swp391.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.model.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findAll();

	Users findByUserId(Integer userId);

	void deleteByUserId(Integer userId);
}
