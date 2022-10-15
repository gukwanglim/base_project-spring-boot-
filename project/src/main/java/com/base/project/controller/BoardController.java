package com.base.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String main() {
        return "main";
    }

    @GetMapping("auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }
    
}
