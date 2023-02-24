package com.study.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/session")
public class SessionController {

    HashMap<String, String> sessionMap = new HashMap<>();

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name){
        sessionMap.put(session.getId(), name);

        return "saved";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session){
        String myName = sessionMap.get(session.getId());

        return myName;
    }
}
