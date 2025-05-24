package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Registry;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryService {
    @Autowired
    private RegistryRepository registryRepository;

    public Registry createRegistry(Registry registry){
        return registryRepository.save(registry);
    }

    public Registry getRegistryById(Long id){
        return registryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + id));
    }

    public List<Registry> getAllRegistries(){
        return registryRepository.findAll();
    }

    public Registry updateRegistry(Long id, Registry updateRegistry){
        Registry registry = getRegistryById(id);
        registry.setEventName(updateRegistry.getEventName());
        registry.setOwnerName(updateRegistry.getOwnerName());
        registry.setDate(updateRegistry.getDate());
        registry.setDescription(updateRegistry.getDescription());
        return registryRepository.save(registry);
    }

    public void deleteRegistry(Long id){
        Registry registry = getRegistryById(id);
        registryRepository.delete(registry);
    }
}
