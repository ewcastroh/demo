package com.carlangas.demo.service;

import com.carlangas.demo.model.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAllClients();

    Client findClientById(Long id) throws Exception;

    Client createClient(Client client);

    void deleteClientById(Long id);
}
