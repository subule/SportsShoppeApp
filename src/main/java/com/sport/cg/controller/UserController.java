package com.sport.cg.controller;

import java.util.List;

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
@RequestMapping("/usersweb/api")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/usersAdd")
	public ResponseEntity<User> createUser(@Validated @RequestBody User user){
		LOGGER.info("adding userintiated");
		User use=userService.createUser(user);
		ResponseEntity<User> response=new ResponseEntity<User>(use, HttpStatus.CREATED);
		return response;
	}

		
	@PostMapping("/usersIn")
	public ResponseEntity<User> signIn(@Validated @RequestBody User user) {
		LOGGER.info("EUser signIn()");
		User returnable = userService.signIn(user);
		return new ResponseEntity<User>(returnable, HttpStatus.OK);
	}

	@PostMapping("/usersOut")
	public ResponseEntity<User> signOut(@Validated @RequestBody User user) {
		LOGGER.info("EUser signOut()");
		User returnable = userService.signOut(user);
		return new ResponseEntity<User>(returnable, HttpStatus.OK);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> changePassword(@PathVariable long id, @Validated @RequestBody User user) {
		LOGGER.info("EUser changePassword()");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		//System.out.println("AllOrderController");
		LOGGER.info("User getAllUser()");
		List<User> allUsers = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

}
