package com.example.sportmarket.mapper;

import com.example.sportmarket.controller.product.ProductDTO;
import com.example.sportmarket.dao.product.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper( ProductMapper.class );

    ProductDTO toDTO(ProductEntity entity);
}
