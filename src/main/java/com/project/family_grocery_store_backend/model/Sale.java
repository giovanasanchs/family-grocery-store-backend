package com.project.family_grocery_store_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double subtotal;
    private Double total;
    private Double amountReceived;
    private Double changeAmount;

    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getSubtotal() { return subtotal; }

    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }

    public Double getAmountReceived() { return amountReceived; }

    public void setAmountReceived(Double amountReceived) { this.amountReceived = amountReceived; }

    public Double getChangeAmount() { return changeAmount; }

    public void setChangeAmount(Double changeAmount) { this.changeAmount = changeAmount; }

    public LocalDateTime getSaleDate() { return saleDate; }

    public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }

    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public List<SaleItem> getItems() { return items; }

    public void setItems(List<SaleItem> items) {
        this.items = items;
        if (items != null) {
            items.forEach(i -> i.setSale(this));
        }
    }
}
