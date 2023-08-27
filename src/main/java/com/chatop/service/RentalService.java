package com.chatop.service;

import java.util.List;

import com.chatop.entities.Rentals;

public interface RentalService {
    
     Rentals addRentals(Rentals rentals);

     List<Rentals> getAllRentals();

     Rentals getRentalsById(Long id);

     void deleteRental(Long id);
}
