package com.example.sportmarket.dao.client;

import com.example.sportmarket.controller.client.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Page<ClientEntity> findAllByFirstName(String name, Pageable pageable);
    Optional<ClientEntity> findByUuid(UUID uuid);

}
