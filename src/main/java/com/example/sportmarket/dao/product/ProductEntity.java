package com.example.sportmarket.dao.product;

import com.example.sportmarket.dao.product_from_order.ProductFromOrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vendor_code")
    private int vendorCode;
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private int count;
    @Column(name = "price", columnDefinition = "NUMERIC", length = 10)
    private double price;
    @Column(name = "name")
    private String  name;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ProductFromOrderEntity> productFromOrderEntities;

}
