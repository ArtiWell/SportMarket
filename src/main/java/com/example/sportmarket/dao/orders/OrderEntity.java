package com.example.sportmarket.dao.orders;

import com.example.sportmarket.dao.client.ClientEntity;
import com.example.sportmarket.dao.product.ProductEntity;
import com.example.sportmarket.service.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private int code;
    @Column(name = "count")
    private int count;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.IN_PROGRESS;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

}
