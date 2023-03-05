package ru.sereda.sau_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secured")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured part");
    }
    @GetMapping("/hello_operator")
    public ResponseEntity<String> sayHelloOperator(){
        return ResponseEntity.ok("Hello from secured part to operator or admin");
    }
    @GetMapping("/hello_admin")
    public ResponseEntity<String> sayHelloAdmin(){
        return ResponseEntity.ok("Hello from secured part to admin");
    }
}
