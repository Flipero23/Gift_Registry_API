package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Item;
import org.example3.model.Registry;
import org.example3.repository.ItemRepository;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RegistryRepository registryRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
    }

    public Item addItemToRegistry(Long registryId, Item item){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        item.setRegistry(registry);
        return itemRepository.save(item);
    }

    public List<Item> getItemsByRegistryId(Long registryId){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        return registry.getItems();
    }

    public Item updateItem(Long itemId, Item updatedItem){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());
        item.setPurchased(updatedItem.isPurchased());
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        itemRepository.delete(item);
    }

    public Item markItemAsPurchased(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        item.setPurchased(true);
        return itemRepository.save(item);
    }
}
