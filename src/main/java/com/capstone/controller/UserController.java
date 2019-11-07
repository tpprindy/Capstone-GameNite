package com.capstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Event;
import com.capstone.entity.User;
import com.capstone.repository.EventsRepository;
import com.capstone.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventsRepository eventsRepository;

	@PostMapping(value = "/login")
	@ResponseBody
	private ResponseEntity<User> login(@RequestBody User user) {
		User databaseUser = this.userRepository.findByEmail(user.getEmail());

		if (user.getPassword().equals(databaseUser.getPassword())) {
			return new ResponseEntity<>(databaseUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/submitUserDetails", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)

	public void submitStudentDetail2(@RequestBody User user) {

		userRepository.save(user);
	}

	@RequestMapping(value = "/submitUserEvent/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)

	public ResponseEntity<String> submitStudentDetail2(@PathVariable String email, @RequestBody Event event) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			event.setEventUser(user);
			eventsRepository.save(event);
			return new ResponseEntity<>("Successfully added event", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Unable to add event", HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping(value = "/retriveAllEvents")
	public ResponseEntity<List<Event>> retriveAllEvents() {
		return new ResponseEntity<List<Event>>(eventsRepository.findAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/retriveMyEvents/{username}")
	public ResponseEntity<List<Event>> retriveMyEvents(@PathVariable String username) {
		User user = userRepository.findByUsername(username);
		return new ResponseEntity<List<Event>>(eventsRepository.findByEventUser(user), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/updateEvent/{userId}")
	public ResponseEntity<String> retriveMyEvents(@PathVariable int userId, @RequestBody Event event) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {	
			event.setEventUser(user.get());
			eventsRepository.save(event);
		}
		return new ResponseEntity<>("Successfully updated event", HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/deleteEvent/{eventId}")
	public ResponseEntity<String> deleteEvent(@PathVariable int eventId) {
		eventsRepository.deleteById(eventId);
		return new ResponseEntity<>("Successfully deleted event", HttpStatus.ACCEPTED);
	}

}
