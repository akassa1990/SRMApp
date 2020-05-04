package edu.mum.cs.cs425.SRMApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.SRMApp.model.Supplier;
import edu.mum.cs.cs425.SRMApp.repository.ISupplierRepository;
import edu.mum.cs.cs425.SRMApp.service.ISupplierService;

@Service("supplierService")
public class SupplierService implements ISupplierService {
	
	@Autowired
	ISupplierRepository supplierRepository;

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier findById(Long id) {
		Optional<Supplier> os = supplierRepository.findById(id);
		return os.orElse(null);
	}

	@Override
	public void delete(Long id) {
		supplierRepository.deleteById(id);
	}
	
}
