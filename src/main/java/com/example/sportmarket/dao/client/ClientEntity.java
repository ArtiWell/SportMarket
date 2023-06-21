package com.example.sportmarket.dao.client;

import com.example.sportmarket.dao.orders.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "status_vip")
    private boolean status;

    @CreationTimestamp
    @Column(name = "date_registration")
    private Date date;

    @OneToMany(mappedBy = "clientEntity", cascade = ALL)
    private List<OrderEntity> orderEntity;


}
