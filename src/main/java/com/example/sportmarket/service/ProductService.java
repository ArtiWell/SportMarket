package com.example.sportmarket.service;

import com.example.sportmarket.controller.product.ProductDTO;
import com.example.sportmarket.dao.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.sportmarket.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(PRODUCT_MAPPER::toDTO);
    }

    public Page<ProductDTO> search(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable)
                .map(PRODUCT_MAPPER::toDTO);
    }

}
