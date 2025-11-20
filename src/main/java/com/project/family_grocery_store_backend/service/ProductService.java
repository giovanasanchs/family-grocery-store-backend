package com.project.family_grocery_store_backend.service;

import com.project.family_grocery_store_backend.dto.ProductDTO;
import com.project.family_grocery_store_backend.model.Category;
import com.project.family_grocery_store_backend.model.Product;
import com.project.family_grocery_store_backend.repository.CategoryRepository;
import com.project.family_grocery_store_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Product product = dto.toEntity(category);
        Product saved = repository.save(product);

        return ProductDTO.fromEntity(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ProductDTO findById(Long id) {
        return repository.findById(id)
                .map(ProductDTO::fromEntity)
                .orElse(null);
    }

    public ProductDTO findByBarcode(String barcode) {
        Product product = repository.findByBarcode(barcode);
        return product != null ? ProductDTO.fromEntity(product) : null;
    }
}
