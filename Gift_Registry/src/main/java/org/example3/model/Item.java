package org.example3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity     //Mark the class as an entity
public class Item {
    @Id   //Sets value as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //Auto increment
    private Long id;

    //Basic attributes
    private String name;
    private double price;
    private int quantity;
    private boolean purchased;   //Whether the item has already been purchased

    @ManyToOne(fetch = FetchType.LAZY)   //Many items can belong to one registry
    @JoinColumn(name = "registry_id")    //Foreign key in the Item table
    @JsonIgnore     //Prevent infinite recursion during JSON serialization
    private Registry registry;

    //Default constructor
    public Item() {
    }


    //Parameterized constructor for creating objects
    public Item(String name, double price, int quantity, boolean purchased, Registry registry) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.purchased = purchased;
        this.registry = registry;
    }


    //Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
