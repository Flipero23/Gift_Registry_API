package org.example3.repository;

import org.example3.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository    //Marks this interface as a repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {
    //The interface automatically provides built-in basic CRUD operations.
}
