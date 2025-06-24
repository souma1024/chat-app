package com.souma1024.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souma1024.chat.model.Chatroom;

import java.util.Optional;

public interface ChatroomRepository extends JpaRepository<Chatroom, Integer>{
    Optional<Chatroom> findByRoomCode(String roomCode);
}
