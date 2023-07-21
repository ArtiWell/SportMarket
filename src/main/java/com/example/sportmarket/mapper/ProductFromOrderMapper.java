package com.example.sportmarket.mapper;

import com.example.sportmarket.controller.product.ProductDTO;
import com.example.sportmarket.dao.product.ProductEntity;
import com.example.sportmarket.dao.product_from_order.ProductFromOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductFromOrderMapper {
    ProductFromOrderMapper PRODUCT_MAPPER = Mappers.getMapper( ProductFromOrderMapper.class );

    @Mapping(target = "vendorCode", source = "entity.productEntity.vendorCode")
    @Mapping(target = "description", source = "entity.productEntity.description")
    @Mapping(target = "price", source = "entity.productEntity.price")
    @Mapping(target = "name", source = "entity.productEntity.name")

    ProductDTO toDTO(ProductFromOrderEntity entity);
}
