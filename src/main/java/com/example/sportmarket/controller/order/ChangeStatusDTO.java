package com.example.sportmarket.controller.order;

import com.example.sportmarket.service.StatusEnum;

public record ChangeStatusDTO(int code, StatusEnum status) {
}

