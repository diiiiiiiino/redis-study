package com.study.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/redis-session")
public class RedisSessionController {
    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name){
        session.setAttribute("name", name);

        return "saved";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session){
        String myName = (String)session.getAttribute("name");

        return myName;
    }
}
