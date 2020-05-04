package edu.mum.cs.cs425.SRMApp.service;

import java.util.List;

import edu.mum.cs.cs425.SRMApp.model.Product;

public interface IProductService {
	public abstract List<Product> findAll();
	public abstract Product save(Product product);
	public abstract Product findById(Long id);
	public abstract void delete(Long id);
}
