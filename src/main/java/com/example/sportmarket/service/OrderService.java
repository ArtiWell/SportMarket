package com.example.sportmarket.service;

import com.example.sportmarket.controller.order.*;
import com.example.sportmarket.dao.client.ClientEntity;
import com.example.sportmarket.dao.client.ClientRepository;
import com.example.sportmarket.dao.orders.OrderEntity;
import com.example.sportmarket.dao.orders.OrderRepository;
import com.example.sportmarket.dao.product.ProductEntity;
import com.example.sportmarket.dao.product.ProductRepository;
import com.example.sportmarket.exception.EntityNotFoundException;
import com.example.sportmarket.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.sportmarket.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    private final CodeGenerator codeGenerator;

    @Transactional
    public int addNewOrder(CreateOrderDTO order) {
        ClientEntity clientEntity = clientRepository.findByUuid(order.clientUuid()).orElseThrow(
                EntityNotFoundException::new
        );
        ProductEntity product = productRepository.findByVendorCode(order.vendorCode()).orElseThrow(
                EntityNotFoundException::new
        );
        if (product.getCount() < order.count()) {
            throw new EntityNotFoundException();
        }
        product.setCount(product.getCount() - order.count());

        OrderEntity entity = new OrderEntity();
        entity.setCode(codeGenerator.generateCode());
        entity.setCount(order.count());
        entity.setProductEntity(product);
        entity.setClientEntity(clientEntity);

        clientEntity.getOrderEntity().add(entity);

        clientRepository.save(clientEntity);

        return entity.getCode();
    }


    @Transactional
    public void changeStatus(ChangeStatusDTO changeStatus) {
        List<OrderEntity> entity = orderRepository.findAllByCode(changeStatus.code());
        for (OrderEntity orderEntity : entity) {
            orderEntity.setStatus(changeStatus.status());
        }
    }

    public List<OrderDTO> getAllOrdersByClient(UUID uuid) {
        return clientRepository.findByUuid(uuid)
                .orElseThrow(EntityNotFoundException::new)
                .getOrderEntity()
                .stream()
                .map(ORDER_MAPPER::toDto)
                .collect(Collectors.toList());
    }

    public void deleteOrderByCode(DeleteOrderDTO dto) {
        orderRepository.deleteByCode(dto.code());
    }
}
