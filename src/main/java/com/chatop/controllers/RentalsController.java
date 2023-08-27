package com.chatop.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatop.entities.Rentals;
import com.chatop.repository.RentalRepository;
import com.chatop.service.RentalService;

import io.jsonwebtoken.io.IOException;
@RestController
@RequestMapping("/rentals")
public class RentalsController {

    private static final String IMAGE_UPLOAD_DIR = "chemin/vers/dossier/images/";

    private final RentalService rentalService;

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalsController(RentalService rentalService, RentalRepository rentalRepository) {
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    @PostMapping
    public ResponseEntity<?> createRental(@RequestParam("image") MultipartFile imageFile,
                                          @RequestBody Rentals rental) throws java.io.IOException {
        try {
            // Upload the image
            String filename = UUID.randomUUID().toString() + "-" + imageFile.getOriginalFilename();
            String imageUrl = IMAGE_UPLOAD_DIR + filename;
            java.nio.file.Path filePath = Paths.get(imageUrl);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            // Set the image URL in the Rental object
            rental.setPicture(imageUrl);

            // Save the rental with image URL
            Rentals savedRental = rentalService.addRentals(rental);

            return ResponseEntity.ok(savedRental);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

    @GetMapping
    public ResponseEntity<List<Rentals>> getAllRentals() {
        List<Rentals> rentals = rentalService.getAllRentals();
        return ResponseEntity.ok(rentals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rentals> updateRental(@PathVariable Long id, @RequestBody Rentals rental) {
        Rentals existingRental = rentalService.getRentalsById(id);
        
        if (existingRental == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingRental.setName(rental.getName());
        existingRental.setUpdatedAt(Timestamp.from(Instant.now()));
        existingRental.setDescription(rental.getDescription());
        existingRental.setPrice(rental.getPrice());
        existingRental.setSurface(rental.getSurface());
        
        Rentals updatedRental = rentalRepository.save(existingRental);
        return ResponseEntity.ok(updatedRental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRental(@PathVariable Long id) {
        Rentals existingRental = rentalService.getRentalsById(id);
        
        if (existingRental == null) {
            return ResponseEntity.notFound().build();
        }
        
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }

}
