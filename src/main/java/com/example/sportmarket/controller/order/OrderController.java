package com.example.sportmarket.controller.order;

import com.example.sportmarket.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("add")
    public int addOrder(@RequestBody CreateOrderDTO order) {
        return service.addNewOrder(order);
    }

    @PostMapping("changeStatus")
    public void changeStatus(@RequestBody ChangeStatusDTO statusDTO) {
        service.changeStatus(statusDTO);
    }

    @GetMapping("client")
    public List<OrderDTO> getAllOrdersByClient(@RequestParam UUID uuid){
       return service.getAllOrdersByClient(uuid);
    }

}
