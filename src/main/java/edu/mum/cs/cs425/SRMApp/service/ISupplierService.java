package edu.mum.cs.cs425.SRMApp.service;

import java.util.List;

import edu.mum.cs.cs425.SRMApp.model.Supplier;

public interface ISupplierService {
	public abstract List<Supplier> findAll();
	public abstract Supplier save(Supplier supplier);
	public abstract Supplier findById(Long id);
	public abstract void delete(Long id);
}
