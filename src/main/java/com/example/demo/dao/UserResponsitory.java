package com.example.demo.dao;

import org.hibernate.boot.jaxb.internal.stax.JpaOrmXmlEventReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<User,String>{
}
