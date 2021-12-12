package com.tarma.auth.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;

@RestController
public class UiController {
    /**
     * This is a useful trick in a Spring Security application.
     * If the "/user" resource wis reachable then it will return the currently authenticated user (an Authentication),
     * and otherwise Spring Security will intercept the request and send a 401 response through
     * an AuthenticationEntryPoint.
     * @param user
     * @return
     */
    @RequestMapping("/user") // GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE
    public Optional<Principal> user(Principal user) {
        return Optional.ofNullable(user);
    }
}