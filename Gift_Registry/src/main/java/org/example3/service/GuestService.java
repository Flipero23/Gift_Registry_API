package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Guest;
import org.example3.model.Registry;
import org.example3.repository.GuestRepository;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //Marks this class as a service
public class GuestService {
    //Auto inject GuestRepository
    @Autowired
    private GuestRepository guestRepository;

    //Auto inject RegistryRepository
    @Autowired
    private RegistryRepository registryRepository;

    //Fetch all guests from the H2 database
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    //Fetch a specific guest by ID, or throw an exception if the ID is not found
    public Guest getGuestById(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
    }

    //Add a new guest to a specific registry
    public Guest addGuestToRegistry(Long registryId, Guest guest){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        guest.setRegistry(registry);   //Set the guest's registry
        return guestRepository.save(guest);   //Save the guest to the database
    }

    //Fetch all guests associated with a specific registry
    public List<Guest> getGuestsByRegistry(Long registryId){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        return registry.getGuests();
    }

    //Update an existing guest's infomration
    public Guest updateGuest(Long guestId, Guest updatedGuest){
        //Find the guest by their ID
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guest.setName(updatedGuest.getName());
        guest.setEmail(updatedGuest.getEmail());     //Set all information
        guest.setHasRSVP(updatedGuest.getHasRSVP());
        return guestRepository.save(guest);   //Save the updated guest information to the database
    }

    //Delete a guest by ID
    public void deleteGuest(Long guestId){
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guestRepository.delete(guest);
    }

    //Mark a guest as having RSVP'd
    public Guest markGuestRSVP(Long guestId){
        //Find guest by ID
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guest.setHasRSVP(true);    //Set RSVP status to true
        return guestRepository.save(guest);    //Save updated status
    }
}
