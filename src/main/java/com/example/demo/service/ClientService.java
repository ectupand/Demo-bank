package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.model.ClientModel;
import com.example.demo.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientModel model){
        Client client = Client.builder()
                .name(model.getName())
                .phone(model.getPhone())
                .build();
        return clientRepository.save(client);
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public Client readById(Long id){
        return clientRepository.findById(id).orElseThrow(()->
                new RuntimeException("Client not found on id " + id));
    }

    public Client findById(Long id){
        return readById(id);
    }

    public List<Client> readByName(String name){
        return clientRepository.findByName(name);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
