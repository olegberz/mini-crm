package com.pet.booking.Controller;

import com.pet.booking.DTO.ClientResponseDTO;
import com.pet.booking.DTO.ClientCreateDTO;
import com.pet.booking.Entity.Client;
import com.pet.booking.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseDTO> getAllClients() {
        return clientService.findAllClientsDTO();
    }

    @PostMapping
    public Client addNewClient(@RequestBody ClientCreateDTO createDTO) {
        return clientService.createClient(createDTO);
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return new ClientResponseDTO(client.getId(), client.getName(), client.getContact());
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody ClientCreateDTO createDTO) {
        return clientService.updateClient(id, createDTO);
    }

}
