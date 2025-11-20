package com.project.family_grocery_store_backend.dto;

import com.project.family_grocery_store_backend.model.Category;
import com.project.family_grocery_store_backend.model.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String barcode;
    private Double purchasePrice;
    private Double salePrice;
    private Integer stockQuantity;
    private Long categoryId;
    private String categoryName;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBarcode() { return barcode; }

    public void setBarcode(String barcode) { this.barcode = barcode; }

    public Double getPurchasePrice() { return purchasePrice; }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() { return salePrice; }

    public void setSalePrice(Double salePrice) { this.salePrice = salePrice; }

    public Integer getStockQuantity() { return stockQuantity; }

    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Long getCategoryId() { return categoryId; }

    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }


    public Product toEntity(Category category) {
        return new Product(
                this.name,
                this.barcode,
                this.purchasePrice,
                this.salePrice,
                this.stockQuantity,
                category
        );
    }

    public static ProductDTO fromEntity(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setBarcode(product.getBarcode());
        dto.setPurchasePrice(product.getPurchasePrice());
        dto.setSalePrice(product.getSalePrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setCategoryId(product.getCategory().getId());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }

}
