package com.chatop.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "RENTAL_USER_MESSAGES")
@Data
public class RentalUserMessage {

    @Id
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rentals rental;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

}
