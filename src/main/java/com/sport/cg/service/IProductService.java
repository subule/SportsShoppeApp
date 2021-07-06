package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Product;

@Service
public interface IProductService {
	
	public Product addProduct(Product product);
	public Product removeProduct(long productId);
	public Product updateProduct(long productId, Product product);
	public Product getProduct(long productId);
	public List<Product> getAllProduct();
	List<Product> getProductsByName(String name);
	List<Product> getProductsBySize(String size);
	List<Product> getProductsByPrice(double price);
	List<Product> getProductsByColor(String color);	

}
