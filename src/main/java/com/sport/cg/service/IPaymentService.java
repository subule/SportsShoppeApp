package com.sport.cg.service;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Payment;

@Service
public interface IPaymentService {
	
	public Payment addPayment(Payment payment);
	public Payment removePayment(Long paymentId);
	public Payment updatePayment(Long paymentId, Payment payment);
    public Payment getPayment(Long paymentid) ;
	public java.util.List<Payment> getAllPaymentDetails();

}
