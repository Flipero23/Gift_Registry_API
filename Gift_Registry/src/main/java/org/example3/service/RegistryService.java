package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Registry;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //Marks the class as a service
public class RegistryService {
    //Auto inject RegistryRepository
    @Autowired
    private RegistryRepository registryRepository;

    //Method to create a new registry and save it in the database
    public Registry createRegistry(Registry registry){
        return registryRepository.save(registry);
    }

    //Method to get a specific registry by its ID or throw an error if the registry does not exist
    public Registry getRegistryById(Long id){
        return registryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + id));
    }

    //Method to get a list of all registries
    public List<Registry> getAllRegistries(){
        return registryRepository.findAll();
    }

    //Method to update an existing registry's attributes
    public Registry updateRegistry(Long id, Registry updateRegistry){
        Registry registry = getRegistryById(id);
        registry.setEventName(updateRegistry.getEventName());
        registry.setOwnerName(updateRegistry.getOwnerName());    //Set all fields with updated values
        registry.setDate(updateRegistry.getDate());
        registry.setDescription(updateRegistry.getDescription());
        return registryRepository.save(registry);   //Save the updated object
    }

    //Method to delete a registry by its ID
    public void deleteRegistry(Long id){
        Registry registry = getRegistryById(id);   //Retrieve the desired registry
        registryRepository.delete(registry);    //Remove the retrieved registry from the database
    }
}
