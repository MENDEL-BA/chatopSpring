package com.chatop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatop.entities.Message;

@Service
public interface MessageService {
    
     Message addMessage(Message message);

     List<Message> getAllMessages();

     Message getMessageById(Long id);

}
