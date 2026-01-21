package com.pet.booking.Service;

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

    public List<Client> findAll(Long id) {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
            return  clientRepository.findById(id).orElse(new Client());
    }

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(client);
    }


}

