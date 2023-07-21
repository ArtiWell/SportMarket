package com.example.sportmarket.controller.order;

import com.example.sportmarket.controller.product.ProductDTO;
import com.example.sportmarket.dao.product.ProductEntity;
import com.example.sportmarket.service.StatusEnum;

import java.util.List;
import java.util.UUID;

public record OrderDTO(
        UUID id,
        StatusEnum status,
        List<ProductDTO> products
){}
