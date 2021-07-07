package com.sport.cg.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.User;
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
				User returnCorrect = new User();
				returnCorrect.setUserId(inUser.get().getUserId());
				returnCorrect.setPassword(inUser.get().getPassword());
				returnCorrect.setRole(inUser.get().getRole());
				return returnCorrect;
			}
			else {
				//throw new PasswordIncorrectException();
				return null;
			}
		}
		else {
			//throw new UserNotFoundException();
			return null;
		}
	}

	@Override
	public User signOut(User user) {
		LOGGER.info("EUser signIn()");
		Optional<User> outUser = userRepository.findById(user.getUserId());
		if(outUser.isPresent()) {
			User returnOut = new User();
			returnOut.setUserId(outUser.get().getUserId());
			returnOut.setPassword(outUser.get().getPassword());
			returnOut.setRole(outUser.get().getRole());
			return returnOut;
		}
		else {
			//throw new UserNotFounException();
			return null;
		}
	}

	
	@Override
	public User changePassword(long id, User user) {
		LOGGER.info("EUser changePassword()");
		Optional<User> changedPasswordUser = userRepository.findById(user.getUserId());
		if(changedPasswordUser.isPresent()) {
			User returnChanged = new User();
			returnChanged.setUserId(changedPasswordUser.get().getUserId());
			returnChanged.setPassword(changedPasswordUser.get().getPassword());
			returnChanged.setRole(changedPasswordUser.get().getRole());
			return returnChanged;
		}
		else {
			//throw new UserNotFounException();
			return null;
		}
	}
	
}