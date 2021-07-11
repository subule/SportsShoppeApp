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
	public List<Product> getProductsByName(String name);
	public List<Product> getProductsBySize(String size);
	public List<Product> getProductsByMrp(double mrp);
	public List<Product> getProductsByColour(String colour);	

}
