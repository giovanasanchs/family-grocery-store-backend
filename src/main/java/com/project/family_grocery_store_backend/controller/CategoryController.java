package com.project.family_grocery_store_backend.controller;

import com.project.family_grocery_store_backend.model.Category;
import com.project.family_grocery_store_backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public Category getByName(@PathVariable String name) {
        return service.findByName(name);
    }
}
