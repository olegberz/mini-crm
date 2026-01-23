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

    public ClientCreateDTO() {
    }

    public ClientCreateDTO(String name, String contact) {
        this.name = name;
        this.contact = contact;
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
}
