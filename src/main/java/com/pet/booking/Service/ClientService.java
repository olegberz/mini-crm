package com.pet.booking.Service;

import com.pet.booking.DTO.ClientCreateDTO;
import com.pet.booking.Entity.Client;
import com.pet.booking.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Transactional
    public Client createClient(ClientCreateDTO createDTO) {
        Client client = new Client();
        client.setName(createDTO.getName());
        client.setContact(createDTO.getContact());
        return clientRepository.save(client);
    }


    @Transactional
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(client);
    }


}

