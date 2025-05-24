package org.example3.service;

import org.example3.exception.ResourceNotFoundException;
import org.example3.model.Guest;
import org.example3.model.Registry;
import org.example3.repository.GuestRepository;
import org.example3.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RegistryRepository registryRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
    }

    public Guest addGuestToRegistry(Long registryId, Guest guest){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        guest.setRegistry(registry);
        return guestRepository.save(guest);
    }

    public List<Guest> getGuestsByRegistry(Long registryId){
        Registry registry = registryRepository.findById(registryId)
                .orElseThrow(() -> new ResourceNotFoundException("Registry not found with id: " + registryId));
        return registry.getGuests();
    }

    public Guest updateGuest(Long guestId, Guest updatedGuest){
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guest.setName(updatedGuest.getName());
        guest.setEmail(updatedGuest.getEmail());
        guest.setHasRSVP(updatedGuest.getHasRSVP());
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId){
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guestRepository.delete(guest);
    }

    public Guest markGuestRSVP(Long guestId){
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + guestId));
        guest.setHasRSVP(true);
        return guestRepository.save(guest);
    }
}
