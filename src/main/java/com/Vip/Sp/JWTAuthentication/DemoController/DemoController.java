package com.Vip.Sp.JWTAuthentication.DemoController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:8100/"})
public class DemoController {
    @GetMapping("/demo")
    public String sayHello() {
        System.out.println("reached");
        return "hello from demo controller";
    }

}
