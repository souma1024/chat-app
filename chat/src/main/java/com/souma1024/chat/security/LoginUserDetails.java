package com.souma1024.chat.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.souma1024.chat.model.User;

public class LoginUserDetails implements UserDetails {
    private final String loginId;
    private final String username;
    private final String password;

    public LoginUserDetails(User user) {
        this.loginId = user.getLoginId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    // 独自フィールドにアクセスする用（UserDetails には含まれていない）
    public String getLoginId() {
        return loginId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // ここで権限（ROLEなど）を返す。とりあえず空のリストでもOK
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 今は使わないので空でもよい
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 常に有効とする
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 常にロックされていないとする
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 資格情報は常に有効とする
    }

    @Override
    public boolean isEnabled() {
        return true; // アカウントは常に有効とする
    }
}
