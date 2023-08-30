package com.chatop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatop.entities.Rentals;
@Service
public interface RentalService {
    
     Rentals addRentals(Rentals rentals);

     List<Rentals> getAllRentals();

     Rentals getRentalsById(Long id);

     void deleteRental(Long id);
}
