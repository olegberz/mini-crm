package com.pet.booking.DTO;

public class clientCreateDTO {
    private String name;
    private String contact;

    public clientCreateDTO() {
    }

    public clientCreateDTO(String name, String contact) {
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
