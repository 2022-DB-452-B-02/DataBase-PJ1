package com.db.db_teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controllerzz
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "/jsp/home.jsp";
    }
}