package com.sport.cg.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@NotNull
	private String productName;
	private String category;
	private String description;
	private String brand;
	private String colour;
	private String size;
	private Double mrp;
	private Double priceAfterDiscount;
	private String inStock;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate expectedDelivery;
	@ManyToOne@JoinColumn(name="orderId")
	private Orders orderEntity;
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="productEntity")
	private List<Cart> cartEntity;
	
	public Product() {
		super();
	}

	public Product(Long productId, String productName, String category, String description, String brand,
			String colour, String size, Double mrp, Double priceAfterDiscount, String inStock,
			LocalDate expectedDelivery, Orders orderEntity, List<Cart> cartEntity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.colour = colour;
		this.size = size;
		this.mrp = mrp;
		this.priceAfterDiscount = priceAfterDiscount;
		this.inStock = inStock;
		this.expectedDelivery = expectedDelivery;
		this.orderEntity = orderEntity;
		this.cartEntity = cartEntity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public LocalDate getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(LocalDate expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public Orders getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(Orders orderEntity) {
		this.orderEntity = orderEntity;
	}

	public List<Cart> getCartEntity() {
		return cartEntity;
	}

	public void setCartEntity(List<Cart> cartEntity) {
		this.cartEntity = cartEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((cartEntity == null) ? 0 : cartEntity.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expectedDelivery == null) ? 0 : expectedDelivery.hashCode());
		result = prime * result + ((inStock == null) ? 0 : inStock.hashCode());
		result = prime * result + ((mrp == null) ? 0 : mrp.hashCode());
		result = prime * result + ((orderEntity == null) ? 0 : orderEntity.hashCode());
		result = prime * result + ((priceAfterDiscount == null) ? 0 : priceAfterDiscount.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (cartEntity == null) {
			if (other.cartEntity != null)
				return false;
		} else if (!cartEntity.equals(other.cartEntity))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedDelivery == null) {
			if (other.expectedDelivery != null)
				return false;
		} else if (!expectedDelivery.equals(other.expectedDelivery))
			return false;
		if (inStock == null) {
			if (other.inStock != null)
				return false;
		} else if (!inStock.equals(other.inStock))
			return false;
		if (mrp == null) {
			if (other.mrp != null)
				return false;
		} else if (!mrp.equals(other.mrp))
			return false;
		if (orderEntity == null) {
			if (other.orderEntity != null)
				return false;
		} else if (!orderEntity.equals(other.orderEntity))
			return false;
		if (priceAfterDiscount == null) {
			if (other.priceAfterDiscount != null)
				return false;
		} else if (!priceAfterDiscount.equals(other.priceAfterDiscount))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", colour=" + colour + ", size=" + size
				+ ", mrp=" + mrp + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", expectedDelivery=" + expectedDelivery + ", orderEntity=" + orderEntity + ", cartEntity="
				+ cartEntity + "]";
	}

		
}
