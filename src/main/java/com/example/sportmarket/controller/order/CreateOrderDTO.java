package com.example.sportmarket.controller.order;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record CreateOrderDTO(
        @Schema(description = "Уникальный номер товара", example = "100003")
        int vendorCode,
        @Schema(description = "Уникальный юид пользователя", example = "423725b8-66bc-4151-bd99-ab5664ef073b")
        UUID clientUuid,
        int count) {
}

