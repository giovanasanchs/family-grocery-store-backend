package com.project.family_grocery_store_backend.controller;

import com.project.family_grocery_store_backend.model.Product;
import com.project.family_grocery_store_backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/barcode/{barcode}")
    public Product getByBarcode(@PathVariable String barcode) {
        return service.findByBarcode(barcode);
    }
}
