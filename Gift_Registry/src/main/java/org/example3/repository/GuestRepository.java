package org.example3.repository;

import org.example3.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByRegistryId(Long registryId);
    List<Guest> findByRegistryIdAndHasRSVP(Long registryId, boolean hasRSVPed);
}
