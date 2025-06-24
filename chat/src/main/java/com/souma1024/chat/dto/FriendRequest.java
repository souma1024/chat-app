package com.souma1024.chat.dto;

public class FriendRequest {
    
    private String roomCode;

    private String friendId;

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return this.roomCode;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getFriendId() {
        return this.friendId;
    }
 
}
