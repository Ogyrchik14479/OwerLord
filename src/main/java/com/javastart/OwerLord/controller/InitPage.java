package com.javastart.OwerLord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitPage {
    @RequestMapping
    public String getTestPage() {
        return "index.html";
    }
}
