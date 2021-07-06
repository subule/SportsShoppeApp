package com.sport.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

}
