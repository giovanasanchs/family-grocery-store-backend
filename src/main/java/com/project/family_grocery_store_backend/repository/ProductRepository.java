package com.project.family_grocery_store_backend.repository;

import com.project.family_grocery_store_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarcode(String barcode);
}
