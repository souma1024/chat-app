package com.souma1024.chat.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserSignupRequest {

    @NotEmpty
    @Size(min = 8, message = "8桁以上入力してください")
    private String loginId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getLoginId () {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId =loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
