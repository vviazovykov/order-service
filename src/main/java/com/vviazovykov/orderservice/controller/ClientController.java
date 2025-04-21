package com.vviazovykov.orderservice.controller;

import com.vviazovykov.orderservice.entity.Client;
import com.vviazovykov.orderservice.service.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Client> searchClients(@RequestParam String query) {
        return clientService.searchClients(query);
    }
}
