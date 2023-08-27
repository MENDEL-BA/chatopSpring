package com.chatop.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.entities.Rentals;
import com.chatop.repository.RentalRepository;
import com.chatop.service.RentalService;

import java.util.List;

@Service
public class RentalsServImpl implements RentalService {

    private final RentalRepository rentalsRepository;

    @Autowired
    public RentalsServImpl(RentalRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    @Override
    public Rentals addRentals(Rentals rentals) {
         return rentalsRepository.save(rentals);
    }

    @Override
    public Rentals getRentalsById(Long id) {
          return rentalsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rental not found"));
    }


    @Override
    public List<Rentals> getAllRentals() {
         return rentalsRepository.findAll();
    }

    @Override
    public void deleteRental(Long id) {
        rentalsRepository.deleteById(id);
    }

}
