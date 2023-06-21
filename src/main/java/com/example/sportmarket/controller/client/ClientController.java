package com.example.sportmarket.controller.client;

import com.example.sportmarket.service.ClientService;
import com.example.sportmarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("all")
    public Page<ClientDTO> clientList(Pageable pageable) {
        return service.getAllClients(pageable);
    }

    @GetMapping("search")
    public Page<ClientDTO> clientList(@RequestParam String firstName, Pageable pageable) {
        return service.search(firstName,pageable);
    }
    @PostMapping("add")
    public UUID addClient(@RequestBody CreateClientRequest client) {
        return service.addNewClient(client);
    }

}
