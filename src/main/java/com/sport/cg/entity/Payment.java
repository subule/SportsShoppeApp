package com.sport.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private String type;
	private String status;
	@OneToOne(mappedBy="paymentEntity")
	private Orders payOrderEntity;
	@OneToMany(mappedBy = "cardPaymentEntity",cascade=CascadeType.ALL)
	private List<Card> cardEntity;
	
	public Payment() {
		super();
	}

	public Payment(Long paymentId, String type, String status, Orders payOrderEntity, List<Card> cardEntity) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.payOrderEntity = payOrderEntity;
		this.cardEntity = cardEntity;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Orders getPayOrderEntity() {
		return payOrderEntity;
	}

	public void setPayOrderEntity(Orders payOrderEntity) {
		this.payOrderEntity = payOrderEntity;
	}

	public List<Card> getCardEntity() {
		return cardEntity;
	}

	public void setCardEntity(List<Card> cardEntity) {
		this.cardEntity = cardEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardEntity == null) ? 0 : cardEntity.hashCode());
		result = prime * result + ((payOrderEntity == null) ? 0 : payOrderEntity.hashCode());
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Payment other = (Payment) obj;
		if (cardEntity == null) {
			if (other.cardEntity != null)
				return false;
		} else if (!cardEntity.equals(other.cardEntity))
			return false;
		if (payOrderEntity == null) {
			if (other.payOrderEntity != null)
				return false;
		} else if (!payOrderEntity.equals(other.payOrderEntity))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", payOrderEntity="
				+ payOrderEntity + ", cardEntity=" + cardEntity + "]";
	}

		
}