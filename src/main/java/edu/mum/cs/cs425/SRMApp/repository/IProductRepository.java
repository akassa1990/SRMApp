package edu.mum.cs.cs425.SRMApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.SRMApp.model.Product;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Long> {

}

