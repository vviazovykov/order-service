package com.vviazovykov.orderservice.service;

import java.util.List;

import com.vviazovykov.orderservice.entity.Client;
import com.vviazovykov.orderservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> searchClients(String query) {
        return clientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(query, query);
    }
}
