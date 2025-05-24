package org.example3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity   //Declares the class as an entity
public class Guest {
    @Id    //Sets value as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto increment
    private Long id;

    //Basic attributes
    private String name;
    private String email;
    private boolean hasRSVP;    //Whether the user has RSVP'd

    @ManyToOne(fetch = FetchType.LAZY)    //Many guest can belong to one registry
    @JoinColumn(name = "registry_id")    //Foreign key in the Guest table
    @JsonIgnore          //Prevent infinite recursion during JSON serialization
    private Registry registry;

    //Default constructor
    public Guest() {
    }

    //Parameterized constructor for creating objects
    public Guest(String name, String email, boolean hasRSVP, Registry registry) {
        this.name = name;
        this.email = email;
        this.hasRSVP = hasRSVP;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getHasRSVP() {
        return hasRSVP;
    }

    public void setHasRSVP(boolean hasRSVP) {
        this.hasRSVP = hasRSVP;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
