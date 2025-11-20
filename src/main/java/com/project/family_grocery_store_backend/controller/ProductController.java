package com.project.family_grocery_store_backend.controller;

import com.project.family_grocery_store_backend.dto.ProductDTO;
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
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/barcode/{barcode}")
    public ProductDTO getByBarcode(@PathVariable String barcode) {
        return service.findByBarcode(barcode);
    }
}
