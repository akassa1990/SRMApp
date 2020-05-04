package edu.mum.cs.cs425.SRMApp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PRODUCTS")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private Long productNumber;
	private String name;
	private double unitPrice;
	private int quantityInStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateSupplied;
	
	@ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Supplier.class)
	private Supplier supplier;
	
	public Product() {
		super();
	}

	public Product(Long productNumber, String name, double unitPrice, int quantityInStock, LocalDate dateSupplied,
			Supplier supplier) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
		this.supplier = supplier;
	}
   /*
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public LocalDate getDateSupplied() {
		return dateSupplied;
	}

	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	*/

}
