package com.pet.booking.Service;

import com.pet.booking.DTO.ClientResponseDTO;
import com.pet.booking.DTO.ClientCreateDTO;
import com.pet.booking.Entity.Client;
import com.pet.booking.Repository.ClientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientResponseDTO> findAllClientsDTO() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> dto = new ArrayList<>();

        for (Client client : clients) {
            dto.add(new ClientResponseDTO(
                    client.getId(),
                    client.getName(),
                    client.getContact()
            ));
        }
        return dto;
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Transactional
    public Client createClient(@NotNull ClientCreateDTO createDTO) {
        Client client = new Client();
        client.setName(createDTO.getName());
        client.setContact(createDTO.getContact());
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Long id, @NotNull ClientCreateDTO createDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

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

