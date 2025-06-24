package com.souma1024.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souma1024.chat.model.UserChatroom;
import com.souma1024.chat.model.User;
import com.souma1024.chat.model.Chatroom;

public interface UserChatroomsRepository extends JpaRepository<UserChatroom, Integer>{
    Boolean existsByUserAndChatroom(User user, Chatroom chatroom);
}
