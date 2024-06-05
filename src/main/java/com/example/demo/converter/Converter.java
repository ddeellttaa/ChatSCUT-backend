package com.example.demo.converter;

import com.example.demo.dao.Chat;
import com.example.demo.dto.ChatDTO;

public class Converter {
    public static ChatDTO converter(Chat chat){
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setChatId(chat.getChatid());
        chatDTO.setTime(chat.getTime());
        chatDTO.setDescription(chat.getDescription());
        return chatDTO;


    }
}
