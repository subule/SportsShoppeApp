package com.sport.cg.testservice;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.cg.repository.IUserRepository;
import com.sport.cg.service.IUserService;
import com.sport.cg.entity.User;

@SpringBootTest
class TestUserService {
	
	@MockBean
	IUserRepository userRepository;
	
	@Autowired
	IUserService userService;

	@Test
	void testSignIn() {
		User testable = new User();
		testable.setUserId(125346L);
		testable.setPassword("Agp@123#");
		testable.setRole("Customer");
		
		Optional<User> findable = Optional.of(testable);
		Mockito.when(userRepository.findById(125346L)).thenReturn(findable);
		assertThat(userService.signIn(testable)).isEqualTo(testable);
	}

	@Test
	void testSignOut() {
		User testable1 = new User();
		testable1.setUserId(125346L);
		testable1.setPassword("Agp@123#");
		testable1.setRole("Customer");
		
		Optional<User> findable = Optional.of(testable1);
		Mockito.when(userRepository.findById(125346L)).thenReturn(findable);
		assertThat(userService.signOut(testable1)).isEqualTo(testable1);
	}

	@Test
	void testChangePassword() {
		User testable1 = new User();
		testable1.setUserId(125346L);
		testable1.setPassword("Agp@123#");
		testable1.setRole("Customer");
		
		Optional<User> findable = Optional.of(testable1);
		Mockito.when(userRepository.findById(125346L)).thenReturn(findable);
		testable1.setPassword("hgT#@165");
		Mockito.when(userRepository.save(testable1)).thenReturn(testable1);
		assertThat(userService.changePassword(125346L, testable1)).isEqualTo(testable1);
	}

}
