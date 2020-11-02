package com.example.demoservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello1";
    }
}
