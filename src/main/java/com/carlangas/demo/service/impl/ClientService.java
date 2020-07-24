package com.carlangas.demo.service.impl;

import com.carlangas.demo.dao.IClientDao;
import com.carlangas.demo.model.Client;
import com.carlangas.demo.service.IClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final IClientDao clientDao;

    public ClientService(IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Client findClientById(Long id) throws Exception {
        return clientDao.findById(id).orElseThrow(() -> new Exception("Client not found"));
    }

    @Override
    public Client createClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDao.deleteById(id);
    }
}
