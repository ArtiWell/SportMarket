package com.example.sportmarket.service;

import com.example.sportmarket.controller.client.ClientDTO;
import com.example.sportmarket.controller.client.CreateClientRequest;
import com.example.sportmarket.dao.client.ClientEntity;
import com.example.sportmarket.dao.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.UUID;

import static com.example.sportmarket.mapper.ClientMapper.CLIENT_MAPPER;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public Page<ClientDTO> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(CLIENT_MAPPER::toDto);
    }

    public Page<ClientDTO> search(String firstName, Pageable pageable) {
        return clientRepository.findAllByFirstName(firstName,pageable)
                .map(CLIENT_MAPPER::toDto);
    }

    public UUID addNewClient(CreateClientRequest client) {
        ClientEntity entity = CLIENT_MAPPER.toEntity(client);
        clientRepository.save(entity);
        return entity.getUuid();
    }
}
