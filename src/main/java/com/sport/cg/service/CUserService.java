package com.sport.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Orders;
import com.sport.cg.entity.User;
import com.sport.cg.exception.OrderNotFoundException;
import com.sport.cg.exception.UserNotFoundException;
import com.sport.cg.repository.IUserRepository;

@Service
public class CUserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CUserService.class);
	
	String regex = "^[a-zA-Z0-9]{8,}$";
	Pattern pattern = Pattern.compile(regex);

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
		
	@Override
	public User signIn(User user) {
		LOGGER.info("signin() service is initiated");
        Long id = user.getUserId();
        String password = user.getPassword();
        User useridrepo = userRepository.findById(id).orElse(null);
        if (useridrepo == null)
        {
            String usernotfound = "No user found by the userid "+id;
            throw new UserNotFoundException(usernotfound);
        }
        else 
        {
            if(id.equals(useridrepo.getUserId()) && password.equals(useridrepo.getPassword())) 
            {
            	LOGGER.info("signin() service has Executed");
                return useridrepo;
            }
            else {
            	throw new UserNotFoundException("User name and password are invalid");
            }
        }
	}

	@Override
	public User signOut(User user) {
		LOGGER.info("User signIn()");
		return userRepository.findById(user.getUserId()).get();
	}

	
	@Override
	public User changePassword(long id, User user) {
		LOGGER.info("User changePassword()");
		Optional<User> changedPasswordUser = userRepository.findById(user.getUserId());
		if(changedPasswordUser.isPresent()) {
			return userRepository.save(user);
		}
		else {
			throw new UserNotFoundException("Password Not Updated. User Not Found");
		}
	}


	@Override
	public List<User> getAllUser() {
			LOGGER.info("EOrder getAllOrders()");
			List<User> allOrders = userRepository.findAll();
			if(allOrders.isEmpty()) {
				throw new UserNotFoundException("No Orders Found");
			}
			else {
				return userRepository.findAll();
			}
		}	
}