package com.carlangas.demo.controller;

import com.carlangas.demo.model.Client;
import com.carlangas.demo.service.IClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String home() {
        return "Home!";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello there!";
    }

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> findAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client findClientById(@PathVariable Long id) throws Exception {
        Client client = clientService.findClientById(id);
        return client;
    }
}
