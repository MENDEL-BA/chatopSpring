package com.chatop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatop.entities.Rentals;

public interface RentalRepository extends JpaRepository<Rentals, Long> {

    Optional<Rentals> findById(Long id);
}
