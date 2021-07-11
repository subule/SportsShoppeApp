package com.sport.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Product;
import com.sport.cg.service.IProductService;

@RestController
@RequestMapping("productsweb/api")
public class ProductController {
	
	private	static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
		
		@Autowired
		private IProductService iProductService;
		
		@PostMapping("/products")
		public ResponseEntity<Object> addProduct(@Validated @RequestBody Product product){
			LOGGER.info("addProduct URL is opened");
			LOGGER.info("addProduct() is initiated");
			Product productDto = null;
			ResponseEntity<Object> productResponse = null;
			productDto = iProductService.addProduct(product);
			productResponse = new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
			LOGGER.info("addProduct() has Executed");
			return productResponse;
			
		}
		
		@DeleteMapping("/products/{productId}")
		public ResponseEntity<Object> removeProduct(@PathVariable long productId){
			LOGGER.info("removeProduct URL is opened");
			LOGGER.info("removeProduct() is initiated");
			Product productDto = null;
			ResponseEntity<Object> productResponse = null;
			productDto = iProductService.removeProduct(productId);
			productResponse = new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
			LOGGER.info("removeProduct() has Executed");
			return productResponse;
		 
		}
		
		@PutMapping("/products/{productId}")
		public ResponseEntity<Object> updateProduct(@PathVariable long productId, @RequestBody Product product){
			LOGGER.info("updateProduct URL is opened");
			LOGGER.info("updateProduct() is initiated");
			Product productDto =null;
			ResponseEntity<Object> productResponse = null;
			productDto = iProductService.updateProduct(productId, product);
			productResponse = new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
			LOGGER.info("updateProduct() has Executed");
			return productResponse;
			
		}
		
		@GetMapping("/productsById/{productId}")
		public ResponseEntity<Object> getProduct(@PathVariable long productId){
			LOGGER.info("getProduct URL is opened");
			LOGGER.info("getProduct() is initiated");
			Product productDto =null;
			ResponseEntity<Object> productResponse = null;
			productDto = iProductService.getProduct(productId);
			productResponse = new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
			LOGGER.info("getProduct() has Executed");
			return productResponse;
		}
		
		@GetMapping("/products")
		public List<Product> getAllProduct()
		{
			LOGGER.info("getAllProducts URL is opened");
			LOGGER.info("getAllProducts() is initiated");
			return iProductService.getAllProduct();
		}
		
		
		@GetMapping("/productsByName/{name}")
		public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name){
			LOGGER.info("Productbyname URL is opened");
			LOGGER.info("Productbyname() is initiated");
			List<Product> products = iProductService.getProductsByName(name);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);	
			
		}
		
		@GetMapping("/productsBySize/{size}")
		public ResponseEntity<List<Product>> getProductsBySize(@PathVariable String size){
			LOGGER.info("Productbysize URL is opened");
			LOGGER.info("Productbysize() is initiated");
			List<Product> bysize = iProductService.getProductsBySize(size);
			ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(bysize, HttpStatus.OK);
			LOGGER.info("Productbysize() has Executed");
			return response;
		}
		
		@GetMapping("/productsByMrp/{mrp}")
		public ResponseEntity<List<Product>> getProductsByPrice(@PathVariable double mrp){
			LOGGER.info("Productbyprice URL is opened");
			LOGGER.info("Productbyprice() is initiated");
			List<Product> byprice = iProductService.getProductsByMrp(mrp);
			ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(byprice, HttpStatus.OK);
			LOGGER.info("Productbyprice() has Executed");
			return response;
		}
		
		@GetMapping("/productsByColour/{colour}")
		public ResponseEntity<List<Product>> getProductsByColor(@PathVariable String colour){
			LOGGER.info("Productbycolor URL is opened");
			LOGGER.info("Productbycolor() is initiated");
			List<Product> bycolor = iProductService.getProductsByColour(colour);
			ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(bycolor,HttpStatus.OK);
			LOGGER.info("Productbycolor() has Executed");
			return response;
		}

}
