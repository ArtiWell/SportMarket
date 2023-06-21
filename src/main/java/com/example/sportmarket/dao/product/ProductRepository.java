package com.example.sportmarket.dao.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Page<ProductEntity> findAllByNameContaining(String name, Pageable pageable);
    Optional<ProductEntity> findByVendorCode(int vendorCode);

}
