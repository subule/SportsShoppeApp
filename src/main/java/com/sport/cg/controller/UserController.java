package com.sport.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.User;
import com.sport.cg.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
		
	@GetMapping(path="/inUser")
	public ResponseEntity<User> signIn(@Validated @RequestBody User user) {
		LOGGER.info("EUser signIn()");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(path="/outUser")
	public ResponseEntity<User> signOut(@Validated @RequestBody User user) {
		LOGGER.info("EUser signOut()");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping(path="/changedPassword/{id}")
	public ResponseEntity<User> changePassword(@PathVariable long id, @Validated @RequestBody User user) {
		LOGGER.info("EUser changePassword()");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
