package com.zenika.service2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @Value("${name:undefined}")
    private String name;

    @GetMapping("/name")
    public String toto() {
        return name;
    }
}
