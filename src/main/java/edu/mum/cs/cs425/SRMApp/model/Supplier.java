package edu.mum.cs.cs425.SRMApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "SUPPLIERS")
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	private int supplierNumber;
	private String name;
	private String contactPhoneNumber;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
	private List<Product> products = new ArrayList<Product>();

	public Supplier() {
		super();
	}

	public Supplier(int supplierNumber, String contactPhoneNumber, List<Product> products) {
		super();
		this.supplierNumber = supplierNumber;
		this.contactPhoneNumber = contactPhoneNumber;
		this.products = products;
	}

	/*	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public int getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(int supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	*/
	
	
}
