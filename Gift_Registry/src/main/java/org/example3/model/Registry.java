package org.example3.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity    //Marks the class as an entity
public class Registry {
    @Id    //Sets value as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //Auto increment
    private Long id;

    //Basic attributes
    private String eventName;
    private String ownerName;
    private LocalDate date;
    private String description;

    //One registry can have many items
    @OneToMany(mappedBy = "registry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    //One registry can have many guests
    @OneToMany(mappedBy = "registry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guest> guests = new ArrayList<>();

    //Default constructor
    public Registry() {
    }

    //Parameterized constructor for creating objects
    public Registry(String eventName, String ownerName, LocalDate date, String description) {
        this.eventName = eventName;
        this.ownerName = ownerName;
        this.date = date;
        this.description = description;
    }


    //Getters and setters for every field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
