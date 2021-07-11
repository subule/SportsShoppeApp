package com.sport.cg.testservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.cg.entity.Cart;
import com.sport.cg.entity.Orders;
import com.sport.cg.entity.Product;
import com.sport.cg.repository.IProductRepository;
import com.sport.cg.service.IProductService;

@SpringBootTest
class TestProductService {

	@MockBean
	IProductRepository iProductRepository;
	
	@Autowired
	IProductService iProductService;
	
	@Test
	void testAddProduct(){
		
		Cart c = new Cart();
		//List<Cart> c22List = new ArrayList<Cart>();
		c.setId(1L);
		c.setImageName("bat.png");
		c.setProductName("bat"); 
		c.setQuantity(2); 
		c.setPrice(798.0); 
		c.setTotal(820.0);
		//c22List.add(c);
		
		Product a = new Product();			
		a.setProductId(1L);
		a.setProductName("Bat"); 
		a.setCategory("cricket");
		a.setDescription("Super bat, signed by Dhoni");
		a.setBrand("MRF");
		a.setColour("Orange");
		a.setSize("35 inches");
		a.setMrp(450.5);
		a.setPriceAfterDiscount(399.9);
		a.setInStock("Y");
		a.setExpectedDelivery(LocalDate.now());
		a.setOrderEntity(null);
		a.setCartEntity(c);
		
		List<Product> b23List = new ArrayList<Product>();			
		Orders b = new Orders();
		b.setOrderId(5L);
		b.setPaymentMethod("Card");
		b.setAmount(250D);
		b.setBillingDate(LocalDate.now());
		b.setPaymentEntity(null);
		b.seteCustomers(null);
		b.setEproductEntity(b23List);
		
		Mockito.when(iProductRepository.save(a)).thenReturn(a);
		Product returned = iProductService.addProduct(a);
		assertThat(returned).isEqualTo(a);
	}

	@Test
	void testRemoveProduct(){
		
		Cart c1 = new Cart();
		//List<Cart> c23List = new ArrayList<Cart>();
		c1.setId(1L);
		c1.setImageName("bat.png");
		c1.setProductName("bat"); 
		c1.setQuantity(2); 
		c1.setPrice(798.0); 
		c1.setTotal(820.0);
		//c23List.add(c1);
		
		Product a1 = new Product();			
		a1.setProductId(1L);
		a1.setProductName("Bat"); 
		a1.setCategory("cricket");
		a1.setDescription("Super bat, signed by Dhoni");
		a1.setBrand("MRF");
		a1.setColour("Orange");
		a1.setSize("35 inches");
		a1.setMrp(450.5);
		a1.setPriceAfterDiscount(399.9);
		a1.setInStock("Y");
		a1.setExpectedDelivery(LocalDate.now());
		a1.setOrderEntity(null);
		a1.setCartEntity(c1);
		
		List<Product> b24List = new ArrayList<Product>();			
		Orders b1 = new Orders();
		b1.setOrderId(5L);
		b1.setPaymentMethod("Card");
		b1.setAmount(250D);
		b1.setBillingDate(LocalDate.now());
		b1.setPaymentEntity(null);
		b1.seteCustomers(null);
		b1.setEproductEntity(b24List);
		
		Optional<Product> ord = Optional.of(a1);
		Mockito.when(iProductRepository.findById(55L)).thenReturn(ord);
		Mockito.when(iProductRepository.existsById(a1.getProductId())).thenReturn(false);
		assertFalse(iProductRepository.existsById(a1.getProductId()));
	}
	
	
	@Test
	void testUpdateProduct(){
		
		Cart c3 = new Cart();
		//List<Cart> c24List = new ArrayList<Cart>();
		c3.setId(1L);
		c3.setImageName("bat.png");
		c3.setProductName("bat"); 
		c3.setQuantity(2); 
		c3.setPrice(798.0); 
		c3.setTotal(820.0);
		//c24List.add(c3);
		
		Product a2 = new Product();			
		a2.setProductId(1L);
		a2.setProductName("Bat"); 
		a2.setCategory("cricket");
		a2.setDescription("Super bat, signed by Dhoni");
		a2.setBrand("MRF");
		a2.setColour("Orange");
		a2.setSize("35 inches");
		a2.setMrp(450.5);
		a2.setPriceAfterDiscount(399.9);
		a2.setInStock("Y");
		a2.setExpectedDelivery(LocalDate.now());
		a2.setOrderEntity(null);
		a2.setCartEntity(c3);
		
		List<Product> b25List = new ArrayList<Product>();			
		Orders b2 = new Orders();
		b2.setOrderId(5L);
		b2.setPaymentMethod("Card");
		b2.setAmount(250D);
		b2.setBillingDate(LocalDate.now());
		b2.setPaymentEntity(null);
		b2.seteCustomers(null);
		b2.setEproductEntity(b25List);
		
		 Optional<Product> o =Optional.of(a2);
	     Mockito.when(iProductRepository.findById(1L)).thenReturn(o);
	     a2.setBrand("Kookaburra");
		 Mockito.when(iProductRepository.save(a2)).thenReturn(a2);
		 assertThat(iProductService.updateProduct(a2.getProductId(), a2)).isEqualTo(a2);
	}

	@Test
	void testFindProductById(){
		
		Cart c4 = new Cart();
		//List<Cart> c25List = new ArrayList<Cart>();
		c4.setId(1L);
		c4.setImageName("bat.png");
		c4.setProductName("bat"); 
		c4.setQuantity(2); 
		c4.setPrice(798.0); 
		c4.setTotal(820.0);
		//c25List.add(c4);
		
		Product a3 = new Product();			
		a3.setProductId(1L);
		a3.setProductName("Bat"); 
		a3.setCategory("cricket");
		a3.setDescription("Super bat, signed by Dhoni");
		a3.setBrand("MRF");
		a3.setColour("Orange");
		a3.setSize("35 inches");
		a3.setMrp(450.5);
		a3.setPriceAfterDiscount(399.9);
		a3.setInStock("Y");
		a3.setExpectedDelivery(LocalDate.now());
		a3.setOrderEntity(null);
		a3.setCartEntity(c4);
		
		List<Product> b26List = new ArrayList<Product>();			
		Orders b3 = new Orders();
		b3.setOrderId(5L);
		b3.setPaymentMethod("Card");
		b3.setAmount(250D);
		b3.setBillingDate(LocalDate.now());
		b3.setPaymentEntity(null);
		b3.seteCustomers(null);
		b3.setEproductEntity(b26List);
		
		Optional<Product> opt = Optional.of(a3);	 	
		Mockito.when(iProductRepository.findById(1L)).thenReturn(opt);
	    assertThat(iProductService.getProduct(1L)).isEqualTo(a3);
	}
	
	
	@Test
	void testgetAllProducts(){
		
		Cart c5 = new Cart();
		//List<Cart> c26List = new ArrayList<Cart>();
		c5.setId(1L);
		c5.setImageName("bat.png");
		c5.setProductName("bat"); 
		c5.setQuantity(2); 
		c5.setPrice(798.0); 
		c5.setTotal(820.0);
		//c26List.add(c5);
		
		Product a4 = new Product();			
		a4.setProductId(1L);
		a4.setProductName("Bat"); 
		a4.setCategory("cricket");
		a4.setDescription("Super bat, signed by Dhoni");
		a4.setBrand("MRF");
		a4.setColour("Orange");
		a4.setSize("35 inches");
		a4.setMrp(450.5);
		a4.setPriceAfterDiscount(399.9);
		a4.setInStock("Y");
		a4.setExpectedDelivery(LocalDate.now());
		a4.setOrderEntity(null);
		a4.setCartEntity(c5);
	
		Product a6 = new Product();			
		a6.setProductId(2L);
		a6.setProductName("Bat"); 
		a6.setCategory("cricket");
		a6.setDescription("Super bat, signed by Dhoni");
		a6.setBrand("MRF");
		a6.setColour("Orange");
		a6.setSize("35 inches");
		a6.setMrp(450.5);
		a6.setPriceAfterDiscount(399.9);
		a6.setInStock("Y");
		a6.setExpectedDelivery(LocalDate.now());
		a6.setOrderEntity(null);
		a6.setCartEntity(c5);
		
		List<Product> b27List = new ArrayList<Product>();			
		Orders b4 = new Orders();
		b4.setOrderId(5L);
		b4.setPaymentMethod("Card");
		b4.setAmount(250D);
		b4.setBillingDate(LocalDate.now());
		b4.setPaymentEntity(null);
		b4.seteCustomers(null);
		b4.setEproductEntity(b27List);
		
		List<Product> oList = new ArrayList<Product>();
		oList.add(a4);
		oList.add(a6);
		
		Mockito.when(this.iProductRepository.findAll()).thenReturn(oList);
		assertThat(this.iProductService.getAllProduct()).isEqualTo(oList);
	}
	
	@Test
	void testFindProductByName(){
		
		Cart c6 = new Cart();
		//List<Cart> c27List = new ArrayList<Cart>();
		c6.setId(1L);
		c6.setImageName("bat.png");
		c6.setProductName("bat"); 
		c6.setQuantity(2); 
		c6.setPrice(798.0); 
		c6.setTotal(820.0);
		//c27List.add(c6);
		
		Product a5 = new Product();			
		a5.setProductId(3L);
		a5.setProductName("Bat"); 
		a5.setCategory("cricket");
		a5.setDescription("Super bat, signed by Dhoni");
		a5.setBrand("MRF");
		a5.setColour("Orange");
		a5.setSize("35 inches");
		a5.setMrp(450.5);
		a5.setPriceAfterDiscount(399.9);
		a5.setInStock("Y");
		a5.setExpectedDelivery(LocalDate.now());
		a5.setOrderEntity(null);
		a5.setCartEntity(c6);
		
		Product a7 = new Product();			
		a7.setProductId(4L);
		a7.setProductName("Bat"); 
		a7.setCategory("cricket");
		a7.setDescription("Super bat, signed by Dhoni");
		a7.setBrand("MRF");
		a7.setColour("Orange");
		a7.setSize("35 inches");
		a7.setMrp(450.5);
		a7.setPriceAfterDiscount(399.9);
		a7.setInStock("Y");
		a7.setExpectedDelivery(LocalDate.now());
		a7.setOrderEntity(null);
		a7.setCartEntity(c6);
		
		List<Product> b28List = new ArrayList<Product>();			
		Orders b5 = new Orders();
		b5.setOrderId(5L);
		b5.setPaymentMethod("Card");
		b5.setAmount(250D);
		b5.setBillingDate(LocalDate.now());
		b5.setPaymentEntity(null);
		b5.seteCustomers(null);
		b5.setEproductEntity(b28List);
		
		List<Product> opt = new ArrayList<Product>();
		opt.add(a5);
		opt.add(a7);
		
	    Mockito.when(iProductRepository.findByProductName("bat")).thenReturn(opt);	    
	    assertThat(iProductService.getProductsByName("bat")).isEqualTo(opt);
	}
	
	@Test
	void testFindProductBySize(){
		
		Cart c7 = new Cart();
		//List<Cart> c28List = new ArrayList<Cart>();
		c7.setId(1L);
		c7.setImageName("bat.png");
		c7.setProductName("bat"); 
		c7.setQuantity(2); 
		c7.setPrice(798.0); 
		c7.setTotal(820.0);
		//c28List.add(c7);
		
		Product a6 = new Product();			
		a6.setProductId(3L);
		a6.setProductName("Bat"); 
		a6.setCategory("cricket");
		a6.setDescription("Super bat, signed by Dhoni");
		a6.setBrand("MRF");
		a6.setColour("Orange");
		a6.setSize("35 inches");
		a6.setMrp(450.5);
		a6.setPriceAfterDiscount(399.9);
		a6.setInStock("Y");
		a6.setExpectedDelivery(LocalDate.now());
		a6.setOrderEntity(null);
		a6.setCartEntity(c7);
		
		Product a8 = new Product();			
		a8.setProductId(5L);
		a8.setProductName("Bat"); 
		a8.setCategory("cricket");
		a8.setDescription("Super bat, signed by Dhoni");
		a8.setBrand("MRF");
		a8.setColour("Orange");
		a8.setSize("35 inches");
		a8.setMrp(450.5);
		a8.setPriceAfterDiscount(399.9);
		a8.setInStock("Y");
		a8.setExpectedDelivery(LocalDate.now());
		a8.setOrderEntity(null);
		a8.setCartEntity(c7);
		
		List<Product> b29List = new ArrayList<Product>();			
		Orders b6 = new Orders();
		b6.setOrderId(5L);
		b6.setPaymentMethod("Card");
		b6.setAmount(250D);
		b6.setBillingDate(LocalDate.now());
		b6.setPaymentEntity(null);
		b6.seteCustomers(null);
		b6.setEproductEntity(b29List);
		
		List<Product> opt = new ArrayList<Product>();
		opt.add(a6);
		opt.add(a8);
		
	    Mockito.when(iProductRepository.findBySize("35 inches")).thenReturn(opt);	    
	    assertThat(iProductService.getProductsBySize("35 inches")).isEqualTo(opt);
	}
	
	@Test
	void testFindProductByMrp(){
		
		Cart c8 = new Cart();
		//List<Cart> c29List = new ArrayList<Cart>();
		c8.setId(1L);
		c8.setImageName("bat.png");
		c8.setProductName("bat"); 
		c8.setQuantity(2); 
		c8.setPrice(798.0); 
		c8.setTotal(820.0);
		//c29List.add(c8);
		
		Product a9 = new Product();			
		a9.setProductId(3L);
		a9.setProductName("Bat"); 
		a9.setCategory("cricket");
		a9.setDescription("Super bat, signed by Dhoni");
		a9.setBrand("MRF");
		a9.setColour("Orange");
		a9.setSize("35 inches");
		a9.setMrp(450.5);
		a9.setPriceAfterDiscount(399.9);
		a9.setInStock("Y");
		a9.setExpectedDelivery(LocalDate.now());
		a9.setOrderEntity(null);
		a9.setCartEntity(c8);
		
		Product a11 = new Product();			
		a11.setProductId(6L);
		a11.setProductName("Bat"); 
		a11.setCategory("cricket");
		a11.setDescription("Super bat, signed by Dhoni");
		a11.setBrand("MRF");
		a11.setColour("Orange");
		a11.setSize("35 inches");
		a11.setMrp(450.5);
		a11.setPriceAfterDiscount(399.9);
		a11.setInStock("Y");
		a11.setExpectedDelivery(LocalDate.now());
		a11.setOrderEntity(null);
		a11.setCartEntity(c8);
		
		List<Product> b22List = new ArrayList<Product>();			
		Orders b7 = new Orders();
		b7.setOrderId(5L);
		b7.setPaymentMethod("Card");
		b7.setAmount(250D);
		b7.setBillingDate(LocalDate.now());
		b7.setPaymentEntity(null);
		b7.seteCustomers(null);
		b7.setEproductEntity(b22List);
		
		List<Product> opt = new ArrayList<Product>();
		opt.add(a9);
		opt.add(a11);
		
	    Mockito.when(iProductRepository.findByMrp(450.5)).thenReturn(opt);	    
	    assertThat(iProductService.getProductsByMrp(450.5)).isEqualTo(opt);
	}
	
	@Test
	void testFindProductByColor(){
		
		Cart c9 = new Cart();
		//List<Cart> c33List = new ArrayList<Cart>();
		c9.setId(1L);
		c9.setImageName("bat.png");
		c9.setProductName("bat"); 
		c9.setQuantity(2); 
		c9.setPrice(798.0); 
		c9.setTotal(820.0);
		//c33List.add(c9);
		
		Product a33 = new Product();			
		a33.setProductId(6L);
		a33.setProductName("Bat"); 
		a33.setCategory("cricket");
		a33.setDescription("Super bat, signed by Dhoni");
		a33.setBrand("MRF");
		a33.setColour("Orange");
		a33.setSize("35 inches");
		a33.setMrp(450.5);
		a33.setPriceAfterDiscount(399.9);
		a33.setInStock("Y");
		a33.setExpectedDelivery(LocalDate.now());
		a33.setOrderEntity(null);
		a33.setCartEntity(c9);
		
		Product a22 = new Product();			
		a22.setProductId(7L);
		a22.setProductName("Bat"); 
		a22.setCategory("cricket");
		a22.setDescription("Super bat, signed by Dhoni");
		a22.setBrand("MRF");
		a22.setColour("Orange");
		a22.setSize("35 inches");
		a22.setMrp(450.5);
		a22.setPriceAfterDiscount(399.9);
		a22.setInStock("Y");
		a22.setExpectedDelivery(LocalDate.now());
		a22.setOrderEntity(null);
		a22.setCartEntity(c9);
		
		List<Product> b24List = new ArrayList<Product>();			
		Orders b8 = new Orders();
		b8.setOrderId(5L);
		b8.setPaymentMethod("Card");
		b8.setAmount(250D);
		b8.setBillingDate(LocalDate.now());
		b8.setPaymentEntity(null);
		b8.seteCustomers(null);
		b8.setEproductEntity(b24List);
		
		List<Product> opt = new ArrayList<Product>();
		opt.add(a22);
		opt.add(a33);
		Mockito.when(iProductRepository.findByColour("Orange")).thenReturn(opt);	    
	    assertThat(iProductService.getProductsByColour("Orange")).isEqualTo(opt);
	}
}
