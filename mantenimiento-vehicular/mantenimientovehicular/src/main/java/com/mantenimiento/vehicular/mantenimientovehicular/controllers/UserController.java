package com.mantenimiento.vehicular.mantenimientovehicular.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.vehicular.mantenimientovehicular.models.User;
import com.mantenimiento.vehicular.mantenimientovehicular.services.UserService;

 

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final BCryptPasswordEncoder passwordEncoder;
  
    public UserController(UserService srv, BCryptPasswordEncoder pass){
        this.service =srv;
        this.passwordEncoder = pass;

    }

    
    @PostMapping()
    public ResponseEntity<String> create(@Valid @RequestBody User newUser){
        String passwordEncode = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(passwordEncode);        
        service.create(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");        
    }
}