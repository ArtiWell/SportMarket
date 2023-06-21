package com.example.sportmarket.controller.order;

import com.example.sportmarket.service.StatusEnum;

public record OrderDTO(
        String name,
        long vendorCode,
        int orderCode,
        int count,
        double price,
        StatusEnum status
){}
