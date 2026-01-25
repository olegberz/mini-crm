package com.pet.booking.Entity;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String contact;
    private String address;
    public Client() {
    }

    public Client(Long id, String name, String contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
