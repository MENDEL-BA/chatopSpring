package com.chatop.service;

import java.util.List;

import com.chatop.entities.Message;


public interface MessageService {
    
     Message addMessage(Message message);

     List<Message> getAllMessages();

     Message getMessageById(Long id);

}
