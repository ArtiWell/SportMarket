package com.example.sportmarket.controller.order;

import java.util.UUID;

public record CreateOrderDTO(int vendorCode, UUID clientUuid, int count) {
}

