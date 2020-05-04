package edu.mum.cs.cs425.SRMApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.SRMApp.model.Supplier;

@Repository("supplierRepository")
public interface ISupplierRepository extends JpaRepository<Supplier, Long> {

}

