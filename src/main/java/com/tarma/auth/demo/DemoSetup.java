package com.tarma.auth.demo;

import com.tarma.auth.model.AppUser;
import com.tarma.auth.service.AppUserService;
import com.tarma.auth.service.AuthUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@AllArgsConstructor
@Component
public class DemoSetup {
    private final AuthUserDetailsService authUserDetailsService;
    private final AppUserService appUserService;

    @EventListener(ApplicationReadyEvent.class)
    public void initDemoContent() {
        System.out.println("APP STARTED!");
        createUserIfNotExists("Enrico");
        createUserIfNotExists("Sue");
    }

    public void createUserIfNotExists(String username) {
        if (log.isDebugEnabled()) log.debug("Checking if user " + username + " exists");
        Optional<AppUser> user = appUserService.findByUsername(username);
        if (user.isEmpty()) {
            if (log.isDebugEnabled()) log.debug("User " + username + " not found, creating new user");
            appUserService.saveAdminUser(username, "test@gmail.com","enrico123");
        } else if (log.isDebugEnabled()) log.debug("User " + username + " found");
    }
}