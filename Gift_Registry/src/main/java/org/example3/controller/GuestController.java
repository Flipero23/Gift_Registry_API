package org.example3.controller;

import org.example3.model.Guest;
import org.example3.model.Registry;
import org.example3.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")   //Set the path for the controller
public class GuestController {
    //Auto inject GuestService
    @Autowired
    private GuestService guestService;

    //Get a list of all guests across all registries
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    //Get a guest by their ID
    @GetMapping("/{guestId}")
    public Guest getGuestById(@PathVariable Long guestId) {
        return guestService.getGuestById(guestId);
    }

    //Add a new guest to a specific registry
    @PostMapping("/registry/{registryId}")
    public Guest addGuestToRegistry(@PathVariable Long registryId, @RequestBody Guest guest){
        return  guestService.addGuestToRegistry(registryId, guest);
    }

    //Get all guests that belong to a specific registry
    @GetMapping("/registry/{registryId}")
    public List<Guest> getGuestsByRegistry(@PathVariable Long registryId){
        return guestService.getGuestsByRegistry(registryId);
    }

    //Update a specific guest's information by their ID
    @PutMapping("/{guestId}")
    public Guest updateGuest(@PathVariable Long guestId, @RequestBody Guest updatedguest){
        return guestService.updateGuest(guestId,updatedguest);
    }

    //Delete a specific user by their ID
    @DeleteMapping("/{guestId}")
    public void deleteGuest(@PathVariable Long guestId){
        guestService.deleteGuest(guestId);
    }

    //Mark a guest as having an RSVP (HasRSVP = true)
    @PatchMapping("/{guestId}/rsvp")
    public Guest markGuestRSVP(@PathVariable Long guestId){
        return guestService.markGuestRSVP(guestId);
    }
}
