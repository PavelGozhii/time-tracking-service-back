package com.threesome.timeTrackingService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String getHello(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "Hello";
    }
}
