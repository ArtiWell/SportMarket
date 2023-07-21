package com.example.sportmarket.mapper;

import com.example.sportmarket.controller.order.OrderDTO;
import com.example.sportmarket.dao.orders.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductFromOrderMapper.class})
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "products", source = "productFromOrderEntities")

    OrderDTO toDto(OrderEntity entity);

}
