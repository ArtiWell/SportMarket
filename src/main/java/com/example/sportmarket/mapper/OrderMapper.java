package com.example.sportmarket.mapper;

import com.example.sportmarket.controller.order.OrderDTO;
import com.example.sportmarket.dao.orders.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "name", source = "productEntity.name")
    @Mapping(target = "vendorCode", source = "productEntity.vendorCode")
    @Mapping(target = "orderCode", source = "code")
    @Mapping(target = "count", source = "count")
    @Mapping(target = "price", source = "productEntity.price")
    @Mapping(target = "status", source = "status")
    OrderDTO toDto(OrderEntity entity);

}
