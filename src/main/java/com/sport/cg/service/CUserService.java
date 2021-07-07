package com.sport.cg.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.User;
import com.sport.cg.exception.UserNotFoundException;
import com.sport.cg.repository.IUserRepository;

@Service
public class CUserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CUserService.class);

	@Override
	public User signIn(User user) {
		LOGGER.info("EUser signIn()");
		Optional<User> inUser = userRepository.findById(user.getUserId());
		if(inUser.isPresent()) {
			if(inUser.get().getPassword().equals(user.getPassword())) {
				return inUser.get();
			}
			else {
				throw new UserNotFoundException("The Password You Entered is Incorrect");
			}
		}
		else {
			throw new UserNotFoundException("No user with the user ID found");
		}
	}

	@Override
	public User signOut(User user) {
		LOGGER.info("EUser signIn()");
		Optional<User> outUser = userRepository.findById(user.getUserId());
		if(outUser.isPresent()) {
			return outUser.get();
		}
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	
	@Override
	public User changePassword(long id, User user) {
		LOGGER.info("EUser changePassword()");
		Optional<User> changedPasswordUser = userRepository.findById(user.getUserId());
		if(changedPasswordUser.isPresent()) {
			return userRepository.save(user);
		}
		else {
			throw new UserNotFoundException("Password Not Updated. User Not Found");
		}
	}
	
}