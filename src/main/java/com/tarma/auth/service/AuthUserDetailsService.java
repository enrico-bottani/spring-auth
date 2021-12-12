package com.tarma.auth.service;

import com.tarma.auth.mapper.AppUserToAuthMapper;
import com.tarma.auth.model.AppUser;
import com.tarma.auth.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    private final AppUserRepository applicationUserDao;

    AuthUserDetailsService(AppUserRepository applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<AppUser> appUser = applicationUserDao.findByUsername(username);
        return appUser.map(AppUserToAuthMapper::map).orElseThrow(() ->
                new UsernameNotFoundException("No user found with username: " + username));
    }
}
