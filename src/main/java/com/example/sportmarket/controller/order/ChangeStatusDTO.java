package com.example.sportmarket.controller.order;

import com.example.sportmarket.service.StatusEnum;

import java.util.UUID;

public record ChangeStatusDTO(UUID id, StatusEnum status) {
}

