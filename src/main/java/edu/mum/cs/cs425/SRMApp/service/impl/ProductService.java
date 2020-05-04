package edu.mum.cs.cs425.SRMApp.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs.cs425.SRMApp.model.Product;
import edu.mum.cs.cs425.SRMApp.repository.IProductRepository;
import edu.mum.cs.cs425.SRMApp.service.IProductService;


@Service("productService")
public class ProductService implements IProductService {
	
	@Autowired
	IProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> os = productRepository.findById(id);
		return os.orElse(null);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
}
