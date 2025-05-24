package org.example3.controller;

import org.example3.model.Item;
import org.example3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping("/registry/{registryId}")
    public Item addItemToRegistry(@PathVariable Long registryId, @RequestBody Item item){
        return itemService.addItemToRegistry(registryId, item);
    }

    @GetMapping("/registry/{registryId}")
    public List<Item> getItemsByRegistryId(@PathVariable Long registryId){
        return itemService.getItemsByRegistryId(registryId);
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item updatedItem){
        return itemService.updateItem(itemId, updatedItem);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
    }

    @PatchMapping("/{itemId}/purchase")
    public Item markItemAsPurchased(@PathVariable Long itemId){
        return itemService.markItemAsPurchased(itemId);
    }
}
