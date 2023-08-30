package com.chatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatop.entities.RentalUserMessage;
@Repository
public interface RentalUserMessageRepository extends JpaRepository<RentalUserMessage, Long> {
}
