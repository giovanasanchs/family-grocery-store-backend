package com.project.family_grocery_store_backend.service;

import com.project.family_grocery_store_backend.model.Product;
import com.project.family_grocery_store_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product findByBarcode(String barcode) {
        return repository.findByBarcode(barcode);
    }
}
