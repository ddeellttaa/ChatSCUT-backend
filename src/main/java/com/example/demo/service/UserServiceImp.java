package com.example.demo.service;

import com.example.demo.converter.Converter;
import com.example.demo.dao.*;
import com.example.demo.dto.ChatDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserResponsitory userResponsitory;

    @Autowired
    private MessageResponsitory messageResponsitory;

    @Autowired
    private ChatResponsitory chatResponsitory;

    @Override
    public User getUserById(String id){
        return userResponsitory.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Message getMessageById(String id) {
        return messageResponsitory.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Message> getMessageByChat(String id){
        List<Message> messageList = messageResponsitory.findBychatid(id);
        messageList.sort(Comparator.comparing(Message::getTime));
        return messageList;

    }

    @Override
    public Chat getChatById(String id) {

        return chatResponsitory.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<ChatDTO> getChatByUser(String id){
        List<Chat> chatList = chatResponsitory.findChatByUser(id);
        chatList.sort(Comparator.comparing(Chat::getTime));
        return chatList.stream()
                .map(chat-> Converter.converter(chat))
                .collect(Collectors.toList());

    }

    @Override
    public boolean authenticate(String id, String password){
        User user = userResponsitory.findById(id).orElse(null);
        return user!=null && user.getPassword().equals(password);

    }

    @Override
    public boolean addNewUser(User user) {
        User u = userResponsitory.save(user);
        return userResponsitory.save(user) == u;

    }

    @Override
    public boolean addNewChat(Chat chat){
        Chat c = chatResponsitory.save(chat);
        return chatResponsitory.save(chat) == c;

    }

    @Override
    public boolean addNewMessage(Message message){
        Message m = messageResponsitory.save(message);
        return messageResponsitory.save(message) == m;
    }

    @Override
    public boolean deleteChat(String id){
        if(chatResponsitory.existsById(id)){
            chatResponsitory.deleteById(id);
            return true;
        }
        else {

            throw new IllegalArgumentException("id not exist");
        }


    }

    @Override
    public Chat updateChat(String id,String description){
        return chatResponsitory.findById(id).map(
                chat -> {
                    chat.setDescription(description);
                    return chatResponsitory.save(chat);
                }
        ).orElse(null);
    }



}
