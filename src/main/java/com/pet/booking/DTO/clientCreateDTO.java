package com.pet.booking.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientCreateDTO {
    @NotBlank
    @Size(min = 2, max = 12, message = "Name can't be longer than 12 letters")
    private String name;
    @NotBlank
    @Size(min = 2, max = 24)
    private String contact;

    private String address;

    public ClientCreateDTO() {
    }

    public ClientCreateDTO(Long id, String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
