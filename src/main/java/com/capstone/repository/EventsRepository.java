package com.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Event;
import com.capstone.entity.User;
@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
	
	

//	public List<Event> findByEventUser(String email);

	
	List<Event> findByEventUser(User eventUser);
	
	
	List<Event> findByUsername(String username);
	
}