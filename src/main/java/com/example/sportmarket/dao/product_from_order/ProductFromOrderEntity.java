package com.example.sportmarket.dao.product_from_order;

import com.example.sportmarket.dao.orders.OrderEntity;
import com.example.sportmarket.dao.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "product_from_order")
@Entity
@Getter
@Setter
public class ProductFromOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Column(name = "count")
    private int count;


}
