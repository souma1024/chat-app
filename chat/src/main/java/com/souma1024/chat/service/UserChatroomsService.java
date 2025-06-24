package com.souma1024.chat.service;

import org.springframework.stereotype.Service;

import com.souma1024.chat.model.Chatroom;
import com.souma1024.chat.model.UserChatroom;
import com.souma1024.chat.model.User;
import com.souma1024.chat.repository.ChatroomRepository;
import com.souma1024.chat.repository.UserChatroomsRepository;
import com.souma1024.chat.repository.UserRepository;

import java.util.Optional;

@Service
public class UserChatroomsService {
    
    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final UserChatroomsRepository userChatroomsRepository;

    public UserChatroomsService(UserRepository userRepository,
                                ChatroomRepository chatroomRepository,
                                UserChatroomsRepository userChatroomsRepository) {
        this.userRepository = userRepository;
        this.chatroomRepository = chatroomRepository;
        this.userChatroomsRepository = userChatroomsRepository;
    }

    public Chatroom createOrJoinRoom(String roomCode, String loginId, String friendId) {
        Optional<User> currentUser = userRepository.findByLoginId(loginId);
        Optional<User> friendUser = userRepository.findByLoginId(friendId);

        

        Chatroom chatroom = chatroomRepository.findByRoomCode(roomCode)
            .orElseGet(() -> {
                Chatroom newRoom = new Chatroom();
                newRoom.setRoomCode(roomCode);
                return chatroomRepository.save(newRoom);
            });

        addUserToRoomIfNotExists(currentUser.get(), chatroom);
        addUserToRoomIfNotExists(friendUser.get(), chatroom);

        return chatroom;
    }

    private void addUserToRoomIfNotExists(User user, Chatroom chatroom) {
        boolean exists = userChatroomsRepository.existsByUserAndChatroom(user, chatroom);
        if (!exists) {
            UserChatroom userChatroom = new UserChatroom();
            userChatroom.setUser(user);
            userChatroom.setChatroom(chatroom);
            userChatroomsRepository.save(userChatroom);
        }
    }
    
}
