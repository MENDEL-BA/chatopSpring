package com.chatop.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.entities.Message;
import com.chatop.entities.User;
import com.chatop.repository.MessageRepository;
import com.chatop.repository.UserRepository;
import com.chatop.service.MessageService;
import com.chatop.service.UserDetailsService;

@Service
public class MessageServImpl implements MessageService{

    private final MessageRepository messageRepository;

    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;

    @Autowired
    private MessageServImpl(MessageRepository messageRepository,  UserDetailsService userDetailsService,
                            UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    public Message addMessage(Message message) {
        Optional<User> user = userRepository.findByEmail(userDetailsService.getEmailOfCurrentUser());
        message.setUser(user.get());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
       return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Message not found"));
    }
    
}
