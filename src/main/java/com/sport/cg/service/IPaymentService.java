package com.sport.cg.service;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Payment;

@Service
public interface IPaymentService {
	
	public Payment addPayment(Payment payment);
	public Payment removePayment(long paymentId);
	public Payment updatePayment(long paymentId, Payment payment);
    public Payment getPayment(long paymentid) ;
	public java.util.List<Payment> getAllPaymentDetails();

}
