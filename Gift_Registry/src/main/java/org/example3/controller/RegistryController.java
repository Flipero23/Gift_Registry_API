package org.example3.controller;

import org.example3.model.Registry;
import org.example3.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registries")   //Set the path for the controller
public class RegistryController {
    //Auto inject RegistryService
    @Autowired
    private RegistryService registryService;

    //Add a new registry
    @PostMapping
    public Registry createRegistry (@RequestBody Registry registry){
        return registryService.createRegistry(registry);
    }

    //Get a list of all registries
    @GetMapping
    public List<Registry> getAllRegistries(){
        return registryService.getAllRegistries();
    }

    //Get a specific registry by its ID
    @GetMapping("/{id}")
    public Registry getRegistryById(@PathVariable Long id){
        return registryService.getRegistryById(id);
    }

    //Update a specific registry's information by its ID
    @PutMapping("/{id}")
    public Registry updateRegistry(@PathVariable Long id, @RequestBody Registry registry){
        return registryService.updateRegistry(id, registry);
    }

    //Delete a specific registry by its ID
    @DeleteMapping("/{id}")
    public void deleteRegistry(@PathVariable Long id){
        registryService.deleteRegistry(id);
    }
}
