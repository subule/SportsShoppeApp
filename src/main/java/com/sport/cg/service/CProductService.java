package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Product;
import com.sport.cg.exception.ProductNotFoundException;
import com.sport.cg.repository.IProductRepository;

@Service
public class CProductService implements IProductService {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(CProductService.class);
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	@Override
	public Product addProduct(Product product) {
		LOGGER.info("addProduct() serivice is initiated");
		Product productEntity = iProductRepository.save(product);
		LOGGER.info("addProduct() service has executed");
		return productEntity;
	}

	@Override
	public Product removeProduct(long productId) {
		LOGGER.info("removeProduct() serivice is initiated");
		Optional<Product> delproduct = iProductRepository.findById(productId);
		if(delproduct.isPresent()) {
			iProductRepository.deleteById(productId);
			LOGGER.info("removeProduct() service has executed");
			return delproduct.get();
		}
		else {
			throw new ProductNotFoundException("No product with the id found");
		}
	}

	
	@Override
	public Product updateProduct(long productId, Product product) {
		LOGGER.info("updateProduct() serivice is initiated");
		Optional<Product> updateProduct = iProductRepository.findById(productId);
		if(updateProduct.isPresent()) {
			LOGGER.info("updateProduct() service has executed");
			return iProductRepository.save(product);
		}
		else {
			throw new ProductNotFoundException("Product not Updated. Product not found");
		}
	}

	@Override
	public Product getProduct(long productId) {
		LOGGER.info("getProduct() serivice is initiated");
		Optional<Product> getProduct = iProductRepository.findById(productId);
		if(getProduct.isPresent()) {
			LOGGER.info("getProduct() service has executed");
			return getProduct.get();
		}
		else {
			throw new ProductNotFoundException("No product with the ID found");
		}
	}

	@Override
	public List<Product> getAllProduct() {
		LOGGER.info("getAllProduct() serivice is initiated");
		List<Product> getAllProduct = iProductRepository.findAll();
		if(getAllProduct.isEmpty()) {
			throw new ProductNotFoundException("No Products Found");
		}
		else {
			LOGGER.info("getAllProduct() service has executed");
			return getAllProduct;
		}
	}
	
	@Override
	public List<Product> getProductsByName(String name)
	{
		LOGGER.info("getProductByName() serivice is initiated");
		List<Product> getProductName = iProductRepository.findByProductName(name);
		if (getProductName == null){
			throw new ProductNotFoundException("No products found by the name "+name);
		}else {
			LOGGER.info("getProductByName() service has executed");
			return getProductName;
		}
	}
	
	
	@Override
	public List<Product> getProductsBySize(String size)
	{
		LOGGER.info("getProductBySize() serivice is initiated");
		List<Product> productSize = iProductRepository.findBySize(size);
		if (productSize == null)
		{
			throw new ProductNotFoundException("No products found by the size "+size);
		}else {
			LOGGER.info("getProductBySize() service has executed");
			return productSize;
		}
	}
	
	@Override
	public List<Product> getProductsByMrp(double mrp)
	{
		LOGGER.info("getProductByPrice() serivice is initiated");
		List<Product> productPrice = iProductRepository.findByMrp(mrp);
		if (productPrice.isEmpty()){
			throw new ProductNotFoundException("No products found by the price "+mrp);
		}else {
			LOGGER.info("getProductByPrice() service has executed");
			return productPrice;
		}
	}
	
	@Override
	public List<Product> getProductsByColour(String colour)
	{
		LOGGER.info("getProductByColour() serivice is initiated");
		List<Product> productColour = iProductRepository.findByColour(colour);
		if (productColour.isEmpty()){
			throw new ProductNotFoundException("No products found by the colour "+colour);
		}else {
			LOGGER.info("getProductByColor() service has executed");
			return productColour;
		}
	}
}
