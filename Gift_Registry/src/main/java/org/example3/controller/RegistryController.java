package org.example3.controller;

import org.example3.model.Registry;
import org.example3.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registries")
public class RegistryController {
    @Autowired
    private RegistryService registryService;

    @PostMapping
    public Registry createRegistry (@RequestBody Registry registry){
        return registryService.createRegistry(registry);
    }

    @GetMapping
    public List<Registry> getAllRegistries(){
        return registryService.getAllRegistries();
    }

    @GetMapping("/{id}")
    public Registry getRegistryById(@PathVariable Long id){
        return registryService.getRegistryById(id);
    }

    @PutMapping("/{id}")
    public Registry updateRegistry(@PathVariable Long id, @RequestBody Registry registry){
        return registryService.updateRegistry(id, registry);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistry(@PathVariable Long id){
        registryService.deleteRegistry(id);
    }
}
