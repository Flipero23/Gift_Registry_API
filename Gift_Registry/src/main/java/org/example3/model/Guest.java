package org.example3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private boolean hasRSVP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;

    public Guest() {
    }

    public Guest(String name, String email, boolean hasRSVP, Registry registry) {
        this.name = name;
        this.email = email;
        this.hasRSVP = hasRSVP;
        this.registry = registry;
    }

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
