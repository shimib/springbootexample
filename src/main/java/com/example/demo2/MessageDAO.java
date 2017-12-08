package com.example.demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long> {
    List<Message> findAllByMsgStartingWith(String prefix);
}
