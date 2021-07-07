package com.sport.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

}
