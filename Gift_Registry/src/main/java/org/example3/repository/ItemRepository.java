package org.example3.repository;

import org.example3.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByRegistryId (Long registryId);
    List<Item> findByRegistryIdAndPurchased (Long registryId, boolean purchased);
}
