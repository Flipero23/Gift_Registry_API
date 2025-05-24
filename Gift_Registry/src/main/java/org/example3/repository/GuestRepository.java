package org.example3.repository;

import org.example3.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository    //Marks this interface as a repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    //Retrieves all guests that belong to a specific registry
    List<Guest> findByRegistryId(Long registryId);

    //Retrieves guests from a specific registry based on their RSVP status
    List<Guest> findByRegistryIdAndHasRSVP(Long registryId, boolean hasRSVPed);

    //These methods along with the built-in basic CRUD operations are automatically implemented
}
