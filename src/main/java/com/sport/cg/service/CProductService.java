package com.sport.cg.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sport.cg.entity.Product;
import com.sport.cg.repository.IProductRepository;

public class CProductService implements IProductService {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(CProductService.class);
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	@Override
	public Product addProduct(Product product) {
		LOGGER.info("addProduct() serivice is initiated");
		Product productEntity;
		if(product == null)
			productEntity = null;
		else {
			productEntity = iProductRepository.save(product);
    	 }

     LOGGER.info("addProduct() service has executed");
     return productEntity;
     
	}

	@Override
	public Product removeProduct(long productId) {
		LOGGER.info("removeProduct() serivice is initiated");
		Product delproduct = iProductRepository.findById(productId).get();
		iProductRepository.delete(delproduct);
		LOGGER.info("removeProduct() service has executed");
		return null;
	}

	
	@Override
	public Product updateProduct(long productId, Product product) {
		LOGGER.info("updateProduct() serivice is initiated");
		Product updateProduct = iProductRepository.findById(productId).get();
		updateProduct = iProductRepository.save(product);
		LOGGER.info("updateProduct() service has executed");
		return updateProduct;
	}

	@Override
	public Product getProduct(long productId) {
		LOGGER.info("getProduct() serivice is initiated");
		Product getProduct = iProductRepository.findById(productId).get();
		LOGGER.info("getProduct() service has executed");
		return getProduct;
	}

	@Override
	public List<Product> getAllProduct() {
		LOGGER.info("getAllProduct() serivice is initiated");
		List<Product> getAllProduct = iProductRepository.findAll();
		LOGGER.info("getAllProduct() service has executed");
		return getAllProduct;
	}
	
	@Override
	public List<Product> getProductsByName(String name)
	{
		LOGGER.info("getProductByName() serivice is initiated");
		List<Product> getProductName = iProductRepository.findByName(name);
		if (getProductName == null)
		{
			String namenotfound = "No products found by the name "+name;
			//throw new ProductsException(namenotfound);
		}
		LOGGER.info("getProductByName() service has executed");
		return getProductName;
	}
	
	
	@Override
	public List<Product> getProductsBySize(String size)
	{
		LOGGER.info("getProductBySize() serivice is initiated");
		List<Product> productSize = iProductRepository.findBySize(size);
		if (productSize == null)
		{
			//String sizenotfound = "No products found by the size "+size;
			//throw new ProductsException(sizenotfound);
		}
		LOGGER.info("getProductBySize() service has executed");
		return productSize;
	}
	
	@Override
	public List<Product> getProductsByPrice(double price)
	{
		LOGGER.info("getProductByPrice() serivice is initiated");
		List<Product> productPrice = iProductRepository.findByPrice(price);
		if (productPrice == null)
		{
			//String pricenotfound = "No products found by the price "+price;
			//throw new ProductsException(pricenotfound);
		}
		LOGGER.info("getProductByPrice() service has executed");
		return productPrice;
		
	}
	
	@Override
	public List<Product> getProductsByColor(String color)
	{
		LOGGER.info("getProductByColor() serivice is initiated");
		List<Product> productColor = iProductRepository.findByColor(color);
		if (productColor == null)
		{
		//	String colornotfound = "No products found by the color "+color;
		//	throw new ProductsException(colornotfound);
		}
		LOGGER.info("getProductByColor() service has executed");
		return productColor;
	}


}
