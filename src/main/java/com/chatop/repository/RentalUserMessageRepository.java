package com.chatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatop.entities.RentalUserMessage;

public interface RentalUserMessageRepository extends JpaRepository<RentalUserMessage, Long> {
}
