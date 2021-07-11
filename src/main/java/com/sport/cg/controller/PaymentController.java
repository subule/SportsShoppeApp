package com.sport.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Payment;
import com.sport.cg.service.IPaymentService;

@RestController
@RequestMapping("/paymentsweb/api")
public class PaymentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	IPaymentService paymentService;
	
	  @PostMapping("/payments")
	  public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {	
	  LOGGER.info("Called POST mapping addPayment() method");
	  return new ResponseEntity<>(paymentService.addPayment(payment), HttpStatus.CREATED); }
	   
	  @DeleteMapping("/payments/{id}")
	  public ResponseEntity<Payment> removePayment(@PathVariable Long id){
	  LOGGER.info("Called DELETE mapping removePayment() method");
	  Payment updatedPayment = paymentService.removePayment(id);
	  return new ResponseEntity<Payment>(updatedPayment, HttpStatus.OK);
		  
	  }
	  
	  @PutMapping("/payments/{id}")
	  public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment){
	  LOGGER.info("Called PUT mapping updatePayment() method");
	  return new ResponseEntity<Payment>(paymentService.updatePayment(payment.getPaymentId(), payment), HttpStatus.ACCEPTED);
  
	  }
	  
	  @GetMapping("/payments/{id}")
	  public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
	  LOGGER.info("Called GET mapping getPayment() method");
	  return new ResponseEntity<Payment>(paymentService.getPayment(id), HttpStatus.OK);
	  }
	  
	  @GetMapping("/payments")
	  public ResponseEntity<List<Payment>> getAllPaymentDetails() {
	  LOGGER.info("Called GET mapping getAllPaymentDetails() method");
      List<Payment> allPayments = paymentService.getAllPaymentDetails();
	  ResponseEntity<List<Payment>> entity = new ResponseEntity<List<Payment>>(allPayments, HttpStatus.OK);
	  return entity;
	  }

}
