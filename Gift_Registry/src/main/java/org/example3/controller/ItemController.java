package org.example3.controller;

import org.example3.model.Item;
import org.example3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")   //Set the path for the controller
public class ItemController {
    //Auto inject ItemService
    @Autowired
    private ItemService itemService;

    //Get a list of all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    //Get a specific item by its ID
    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    //Add a new item to a specific registry
    @PostMapping("/registry/{registryId}")
    public Item addItemToRegistry(@PathVariable Long registryId, @RequestBody Item item){
        return itemService.addItemToRegistry(registryId, item);
    }

    //Get a list of all items in a specific registry
    @GetMapping("/registry/{registryId}")
    public List<Item> getItemsByRegistryId(@PathVariable Long registryId){
        return itemService.getItemsByRegistryId(registryId);
    }

    //Update information about a specific item by its id
    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item updatedItem){
        return itemService.updateItem(itemId, updatedItem);
    }

    //Delete an item by its ID
    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
    }

    //Mark item as purchased (isPurchased = true)
    @PatchMapping("/{itemId}/purchase")
    public Item markItemAsPurchased(@PathVariable Long itemId){
        return itemService.markItemAsPurchased(itemId);
    }
}
