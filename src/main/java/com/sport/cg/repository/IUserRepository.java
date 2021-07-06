package com.sport.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
