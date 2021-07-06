package com.sport.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Card {
	
	@Id
	private Long CardId;
	@NotNull
	private String cardName;
	@NotNull
	private String cardNumber;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate expiryDate;
	@NotNull
	private String bankName;
	@ManyToOne
	private Payment cardPaymentEntity;
	
	public Card() {
		super();
	}

	public Card(Long cardId, String cardName, String cardNumber, LocalDate expiryDate,
			String bankName, Payment cardPaymentEntity) {
		super();
		CardId = cardId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
		this.cardPaymentEntity = cardPaymentEntity;
	}

	public Long getCardId() {
		return CardId;
	}

	public void setCardId(Long cardId) {
		CardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Payment getCardPaymentEntity() {
		return cardPaymentEntity;
	}

	public void setCardPaymentEntity(Payment cardPaymentEntity) {
		this.cardPaymentEntity = cardPaymentEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CardId == null) ? 0 : CardId.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardPaymentEntity == null) ? 0 : cardPaymentEntity.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
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
		Card other = (Card) obj;
		if (CardId == null) {
			if (other.CardId != null)
				return false;
		} else if (!CardId.equals(other.CardId))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardPaymentEntity == null) {
			if (other.cardPaymentEntity != null)
				return false;
		} else if (!cardPaymentEntity.equals(other.cardPaymentEntity))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [CardId=" + CardId + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + ", bankName=" + bankName + ", cardPaymentEntity=" + cardPaymentEntity + "]";
	}

	
		
}
