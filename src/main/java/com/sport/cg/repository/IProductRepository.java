package com.sport.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sport.cg.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "SELECT * FROM products p WHERE p.product_name = ?1",nativeQuery = true)
	 List<Product> findByName(String name);
	 
	 @Query(value = "SELECT * FROM products p WHERE p.product_size = ?1",nativeQuery = true)
	 List<Product> findBySize(String size);

	 @Query(value = "SELECT * FROM products p WHERE p.product_mrp = ?1",nativeQuery = true)
	 List<Product> findByPrice(double price);
	 
	 @Query(value = "SELECT * FROM products p WHERE p.product_colour = ?1",nativeQuery = true)
	 List<Product> findByColor(String color);

}
