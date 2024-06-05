package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatResponsitory extends JpaRepository<Chat,String> {
    List<Chat> findChatByUser(String id);
    void deleteChatBychatid(String id);
}
