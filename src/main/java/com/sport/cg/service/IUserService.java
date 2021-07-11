package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.User;

@Service
public interface IUserService {
	
	public User createUser(User user);
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
	public List<User> getAllUser();

}
