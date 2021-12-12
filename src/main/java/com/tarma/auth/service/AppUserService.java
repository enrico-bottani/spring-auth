package com.tarma.auth.service;

import com.tarma.auth.config.UserRole;
import com.tarma.auth.model.AppUser;
import com.tarma.auth.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class AppUserService {
    private final AppUserRepository appUserRepo;
    private final PasswordEncoder passwordEncoder;
    public void saveAdminUser(String username, String email, String password) {
        appUserRepo.save(AppUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .userRole(UserRole.ADMIN)
                .email(email)
                .enabled(true).build());
    }
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

}
