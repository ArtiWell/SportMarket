package com.example.sportmarket.mapper;

import com.example.sportmarket.controller.client.ClientDTO;
import com.example.sportmarket.controller.client.CreateClientRequest;
import com.example.sportmarket.dao.client.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDto(ClientEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderEntity", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID())")
    ClientEntity toEntity(CreateClientRequest DTO);
}
