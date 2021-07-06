package com.sport.cg.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@NotNull
	private Double amount;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate billingDate;
    @NotNull
	private String paymentMethod;
    @ManyToOne
	private Customer eCustomers;
	@OneToMany(mappedBy="orderEntity",cascade = CascadeType.ALL)
	private List<Product> eproductEntity;
	@OneToOne @JoinColumn(name="paymentId")
	private Payment paymentEntity;
	
	public Orders() {
		super();
	}

	public Orders(Long orderId, Double amount, LocalDate billingDate, String paymentMethod,
			Customer eCustomers, List<Product> eproductEntity, Payment paymentEntity) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.eCustomers = eCustomers;
		this.eproductEntity = eproductEntity;
		this.paymentEntity = paymentEntity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Customer geteCustomers() {
		return eCustomers;
	}

	public void seteCustomers(Customer eCustomers) {
		this.eCustomers = eCustomers;
	}

	public List<Product> getEproductEntity() {
		return eproductEntity;
	}

	public void setEproductEntity(List<Product> eproductEntity) {
		this.eproductEntity = eproductEntity;
	}

	public Payment getPaymentEntity() {
		return paymentEntity;
	}

	public void setPaymentEntity(Payment paymentEntity) {
		this.paymentEntity = paymentEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((billingDate == null) ? 0 : billingDate.hashCode());
		result = prime * result + ((eCustomers == null) ? 0 : eCustomers.hashCode());
		result = prime * result + ((eproductEntity == null) ? 0 : eproductEntity.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((paymentEntity == null) ? 0 : paymentEntity.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (billingDate == null) {
			if (other.billingDate != null)
				return false;
		} else if (!billingDate.equals(other.billingDate))
			return false;
		if (eCustomers == null) {
			if (other.eCustomers != null)
				return false;
		} else if (!eCustomers.equals(other.eCustomers))
			return false;
		if (eproductEntity == null) {
			if (other.eproductEntity != null)
				return false;
		} else if (!eproductEntity.equals(other.eproductEntity))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (paymentEntity == null) {
			if (other.paymentEntity != null)
				return false;
		} else if (!paymentEntity.equals(other.paymentEntity))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", paymentMethod="
				+ paymentMethod + ", eCustomers=" + eCustomers + ", eproductEntity=" + eproductEntity
				+ ", paymentEntity=" + paymentEntity + "]";
	}

}
