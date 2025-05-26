package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Item;
import org.example3.model.Registry;
import org.example3.repository.ItemRepository;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service     //Marks the class as a service
public class ItemService {
    //Auto injects the ItemRepository
    @Autowired
    private ItemRepository itemRepository;

    //Auto injects the RegistryRepository
    @Autowired
    private RegistryRepository registryRepository;

    //Method to retrieve all items from the database
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    //Method to fetch a specific item by its ID, or throw an exception if the item does not exist
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
    }

    //Method to add a new item to a specific registry, or throw an exception if the registry does not exist
    public Item addItemToRegistry(Long registryId, Item item){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        item.setRegistry(registry);   //Set the registry reference to the item
        return itemRepository.save(item);   //Save the item
    }

    //Method to get all items that belong to a specific registry, or throw an exception if the registry does not exist
    public List<Item> getItemsByRegistryId(Long registryId){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        return registry.getItems();    //Return a list of the items in that registry
    }

    //Method to update the attributes of an existing item, or throw an exception if the item does not exist
    public Item updateItem(Long itemId, Item updatedItem){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());    //Set all fields with updated values
        item.setPurchased(updatedItem.isPurchased());
        return itemRepository.save(item);  //Save the updated item
    }

    //Method to delete a specific item by its ID, or throw an exception if the item does not exist
    public void deleteItem(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        itemRepository.delete(item);   //Remove the item from the database
    }

    //Method to mark the item as purchased, or throw an exception if the item does not exist
    public Item markItemAsPurchased(Long itemId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        item.setPurchased(true);  //Set the value to true to mark the item as purchased
        return itemRepository.save(item);   //Save the made changes
    }
}
