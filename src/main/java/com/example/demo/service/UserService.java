package com.example.demo.service;

import com.example.demo.dao.Chat;
import com.example.demo.dao.Message;
import com.example.demo.dao.User;
import com.example.demo.dto.ChatDTO;

import java.util.List;

public interface UserService {

    public User getUserById(String id);

    public Message getMessageById(String id);
    public List<Message> getMessageByChat(String id);

    public Chat getChatById(String id);
    public List<ChatDTO> getChatByUser(String id);


    boolean authenticate(String id, String password);

    boolean addNewUser(User user);
    boolean addNewChat(Chat chat);
    boolean addNewMessage(Message message);

    boolean deleteChat(String id);

    public Chat updateChat(String id, String description);
}
