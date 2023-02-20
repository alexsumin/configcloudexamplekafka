package com.example.demo.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@NoArgsConstructor
@RefreshScope
public class StateController {

    @Value("${odin:empty}")
    private String value;
    @Value("${dva:empty}")
    private String dva;

    @GetMapping("/current-state")
    public String getMethod()  {
        return value + " " + dva;
    }
}



