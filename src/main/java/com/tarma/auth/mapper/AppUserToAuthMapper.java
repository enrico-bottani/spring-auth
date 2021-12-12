package com.tarma.auth.mapper;

import com.tarma.auth.model.AppUser;
import org.springframework.security.core.userdetails.User;

public class AppUserToAuthMapper {
    public static User map(AppUser appUser){
        return new User(appUser.getUsername(), appUser.getPassword(), appUser.isEnabled(), true,
                true, true, appUser.getUserRole().getAuthorities());
    }
}
