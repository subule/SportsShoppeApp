package com.sport.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Orders;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {

}
