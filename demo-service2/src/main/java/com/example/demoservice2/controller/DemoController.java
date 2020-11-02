package com.example.demoservice2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello2";
    }
}
