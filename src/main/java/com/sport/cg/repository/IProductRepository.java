package com.sport.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	
	 List<Product> findByProductName(String name);
	 
	 List<Product> findBySize(String size);

	 List<Product> findByMrp(double mrp);
	 
	 List<Product> findByColour(String colour);

}
