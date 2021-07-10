package com.sport.cg.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "contactno")
	private String contactNo;
	@Column(name = "DateOfBirth")
	private LocalDate doB;
	@OneToMany(mappedBy = "customerEntity")
	private List<Address> addressEntity;
	@OneToMany(mappedBy="eCustomers")
	private List<Orders> custOrderEntity;
	
	public Customer() {
		super();
	}

	public Customer(Long id, String name, String email, String contactNo, LocalDate doB, List<Address> addressEntity,
			List<Orders> custOrderEntity) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.doB = doB;
		this.addressEntity = addressEntity;
		this.custOrderEntity = custOrderEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDoB() {
		return doB;
	}

	public void setDoB(LocalDate doB) {
		this.doB = doB;
	}

	public List<Address> getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(List<Address> addressEntity) {
		this.addressEntity = addressEntity;
	}

	public List<Orders> getCustOrderEntity() {
		return custOrderEntity;
	}

	public void setCustOrderEntity(List<Orders> custOrderEntity) {
		this.custOrderEntity = custOrderEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressEntity == null) ? 0 : addressEntity.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((custOrderEntity == null) ? 0 : custOrderEntity.hashCode());
		result = prime * result + ((doB == null) ? 0 : doB.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (addressEntity == null) {
			if (other.addressEntity != null)
				return false;
		} else if (!addressEntity.equals(other.addressEntity))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (custOrderEntity == null) {
			if (other.custOrderEntity != null)
				return false;
		} else if (!custOrderEntity.equals(other.custOrderEntity))
			return false;
		if (doB == null) {
			if (other.doB != null)
				return false;
		} else if (!doB.equals(other.doB))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", doB="
				+ doB + ", addressEntity=" + addressEntity + ", custOrderEntity=" + custOrderEntity + "]";
	}

			
}
