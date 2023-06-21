package com.example.sportmarket.dao.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private long vendorCode;
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private int count;
    @Column(name = "price")
    private double price;
    @Column(name = "name")
    private String  name;

}
