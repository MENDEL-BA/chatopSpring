package com.chatop.chatop;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chatop.entities.Rentals;
import com.chatop.service.RentalService;

@Component
public class MyRunner implements CommandLineRunner {

	private final RentalService rentalRepository;
    @Autowired
    public MyRunner(RentalService rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      
            Rentals r = new Rentals();
            r.setName("Test");
            r.setPrice(BigDecimal.valueOf(205));
            r.setDescription("test descr");
            Rentals rs = rentalRepository.addRentals(r);
            System.out.println("rrrrrrrrrrrrrrrrrr "+rs.getId());
        
    }

}
