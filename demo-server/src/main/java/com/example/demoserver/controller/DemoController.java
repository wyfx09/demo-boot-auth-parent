package com.example.demoserver.controller;

import com.example.demoserver.dto.AppResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("get")
    public String get(){
        return this.getClass().getSimpleName();
    }

    @GetMapping("login")
    public AppResult login(){
        return AppResult.builder().msg("请求成功").build();
    }
}
