package com.pet.booking.Controller;

import com.pet.booking.Entity.Client;
import com.pet.booking.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @PostMapping
    public Client addNewClient(@RequestParam String name,
                               @RequestParam String contact) {
        return clientService.createClient(name, contact);
    }



    @GetMapping("/{id}")
    public @ResponseBody Client getClientById(@PathVariable Long id){
        return  clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
