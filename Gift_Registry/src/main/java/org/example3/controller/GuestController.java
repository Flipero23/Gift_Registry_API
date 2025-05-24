package org.example3.controller;

import org.example3.model.Guest;
import org.example3.model.Registry;
import org.example3.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{guestId}")
    public Guest getGuestById(@PathVariable Long guestId) {
        return guestService.getGuestById(guestId);
    }


    @PostMapping("/registry/{registryId}")
    public Guest addGuestToRegistry(@PathVariable Long registryId, @RequestBody Guest guest){
        return  guestService.addGuestToRegistry(registryId, guest);
    }

    @GetMapping("/registry/{registryId}")
    public List<Guest> getGuestsByRegistry(@PathVariable Long registryId){
        return guestService.getGuestsByRegistry(registryId);
    }

    @PutMapping("/{guestId}")
    public Guest updateGuest(@PathVariable Long guestId, @RequestBody Guest updatedguest){
        return guestService.updateGuest(guestId,updatedguest);
    }

    @DeleteMapping("/{guestId}")
    public void deleteGuest(@PathVariable Long guestId){
        guestService.deleteGuest(guestId);
    }

    @PatchMapping("/{guestId}/rsvp")
    public Guest markGuestRSVP(@PathVariable Long guestId){
        return guestService.markGuestRSVP(guestId);
    }
}
