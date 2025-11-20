package com.project.family_grocery_store_backend.controller;

import com.project.family_grocery_store_backend.model.PaymentMethod;
import com.project.family_grocery_store_backend.service.PaymentMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
@CrossOrigin(origins = "*")
public class PaymentMethodController {

    private final PaymentMethodService service;

    public PaymentMethodController(PaymentMethodService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaymentMethod> getAll() {
        return service.findAll();
    }

    @PostMapping
    public PaymentMethod save(@RequestBody PaymentMethod paymentMethod) {
        return service.save(paymentMethod);
    }

    @GetMapping("/{id}")
    public PaymentMethod getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/name/{name}")
    public PaymentMethod getByName(@PathVariable String name) {
        return service.findByName(name);
    }
}
