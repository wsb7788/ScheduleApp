package com.example.projectpractice.controller


import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller

class LoginController {

    @GetMapping("/login")
    fun login():ResponseEntity<String> {
        print("asd")
        return ResponseEntity.ok("HelloWorld")

    }

}