package com.project.family_grocery_store_backend.repository;

import com.project.family_grocery_store_backend.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    PaymentMethod findByName(String name);
}
