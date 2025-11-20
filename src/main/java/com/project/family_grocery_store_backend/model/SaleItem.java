package com.project.family_grocery_store_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sale_items")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double unitPrice;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getUnitPrice() { return unitPrice; }

    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }

    public Sale getSale() { return sale; }

    public void setSale(Sale sale) { this.sale = sale; }
}
