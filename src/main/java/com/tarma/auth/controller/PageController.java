package com.tarma.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {
    @GetMapping
    String getPages(Model model) {
        return "index";
    }
}