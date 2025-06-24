package com.souma1024.chat.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.souma1024.chat.dto.FriendRequest;
import com.souma1024.chat.security.LoginUserDetails;
import com.souma1024.chat.service.UserChatroomsService;
import com.souma1024.chat.util.AuthUtil;


@Controller
@RequestMapping
public class FriendController {

    private final UserChatroomsService userChatroomsService;

    public FriendController(UserChatroomsService userChatroomsService) {
        this.userChatroomsService = userChatroomsService;
    }

    
    @GetMapping("/friend")
    public String showFriend(Model model) {
        model.addAttribute("friendRequest", new FriendRequest());

        return "friend";
    }
    
    @PostMapping("/friend")
    public String createRoom(@ModelAttribute FriendRequest request, Principal principal, Model model) {

        final String roomCode = request.getRoomCode();
        final String friendId = request.getFriendId();
        System.out.println(roomCode + friendId);
        userChatroomsService.createOrJoinRoom(roomCode, roomCode, friendId);


        LoginUserDetails userDetails = AuthUtil.getCurrentUser();

        if (userDetails != null) {
            model.addAttribute("loginId", userDetails.getLoginId());
            model.addAttribute("username", userDetails.getUsername());
        }


        return "redirect:/chat?roomCode=" + roomCode;

    }

}
