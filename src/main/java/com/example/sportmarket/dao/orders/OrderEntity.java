package com.example.sportmarket.dao.orders;

import com.example.sportmarket.dao.client.ClientEntity;
import com.example.sportmarket.dao.product.ProductEntity;
import com.example.sportmarket.dao.product_from_order.ProductFromOrderEntity;
import com.example.sportmarket.service.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.IN_PROGRESS;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<ProductFromOrderEntity> productFromOrderEntities = new ArrayList<>();

}
