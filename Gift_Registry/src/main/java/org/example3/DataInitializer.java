package org.example3;

import org.example3.model.Guest;
import org.example3.model.Item;
import org.example3.model.Registry;
import org.example3.repository.GuestRepository;
import org.example3.repository.ItemRepository;
import org.example3.repository.RegistryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration    //Marks the class as a configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            RegistryRepository registryRepository,
            GuestRepository guestRepository,
            ItemRepository itemRepository
    ) {
        return args -> {
            //Create the registries
            Registry registry1 = new Registry("Gorazd's Birthday Party", "Gorazd", LocalDate.of(2025, 5, 21), "Gorazd's birthday party gifts registry");
            Registry registry2 = new Registry("Marko & Anastasija's Wedding", "Marko & Anastasija", LocalDate.of(2025, 8, 22), "Wedding celebration registry");

            registryRepository.saveAll(List.of(registry1, registry2));  //Save the registries in a list

            //Create the guests for the registries
            Guest guest1 = new Guest("Marija", "marija@yahoo.com", true, registry1);
            Guest guest2 = new Guest("David", "david@gmail.com", false, registry1);
            Guest guest3 = new Guest("Mila", "mila@outlook.com", true, registry2);

            guestRepository.saveAll(List.of(guest1, guest2, guest3));  //Save the guests in a list

            //Create the items for the registries
            Item item1 = new Item("Bluetooth Speaker", 59.99, 2, false, registry1);
            Item item2 = new Item("Coffee Machine", 89.50, 1, true, registry1);
            Item item3 = new Item("Toaster", 29.80, 1, false, registry2);
            Item item4 = new Item("Cutlery Set", 49.35, 1, false, registry2);
            Item item5 = new Item("Headphones", 99.00, 1, true, registry1);
            Item item6 = new Item("Book set", 21.50, 3, true, registry2);

            itemRepository.saveAll(List.of(item1, item2, item3, item4, item5, item6)); //Save the items in a list
        };
    }
}
