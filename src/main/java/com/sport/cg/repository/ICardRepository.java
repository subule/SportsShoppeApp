package com.sport.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Card;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {

}
