package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageResponsitory extends JpaRepository<Message,String> {
    List<Message> findBychatid(String chatid);

}
