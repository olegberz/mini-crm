package com.pet.booking.Controller;

import com.pet.booking.Entity.Client;
import com.pet.booking.Service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String showClientPage() {
        return "client";
    }

    @PostMapping("/clients")
    public @ResponseBody String addNewClient(@RequestParam String name,
                               @RequestParam String contact) {

       return addNewClient(name, contact);
    }

    @GetMapping("/clients/{id}")
    public @ResponseBody Client getClientById(@PathVariable Long id){
        return  clientService.findById(id);
    }

    @DeleteMapping("/clients/delete")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
