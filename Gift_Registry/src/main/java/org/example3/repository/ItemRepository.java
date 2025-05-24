package org.example3.repository;

import org.example3.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository    //Marks this interface as a repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    //Returns a list of items that belong to a specific registry
    List<Item> findByRegistryId (Long registryId);

    //Returns items from a specific registry based on whether they have been purchased
    List<Item> findByRegistryIdAndPurchased (Long registryId, boolean purchased);

    //These methods along with the built-in basic CRUD operations are automatically implemented

}
