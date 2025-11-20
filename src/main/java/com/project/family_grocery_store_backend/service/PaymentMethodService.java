package com.project.family_grocery_store_backend.service;

import com.project.family_grocery_store_backend.model.PaymentMethod;
import com.project.family_grocery_store_backend.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository repository;

    public PaymentMethodService(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public List<PaymentMethod> findAll() {
        return repository.findAll();
    }

    public PaymentMethod save(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PaymentMethod findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PaymentMethod findByName(String name) {
        return repository.findByName(name);
    }
}
