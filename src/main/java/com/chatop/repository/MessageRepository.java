package com.chatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatop.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
