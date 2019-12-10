package com.PocketHome.web;

import com.PocketHome.model.User;
import com.PocketHome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;


import javax.validation.Valid;

@RestController
public class UserController2 {
    @Autowired
    private UserRepository userRepository;

    // Insert new user
    @PostMapping(value = "/users")
     User newUser (@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    // Get the user info
    @GetMapping(value = "/users/{id}")
    User getUser (@PathVariable(value = "id") Long userId){
        return userRepository.findById(userId).get();
    }

    // Alter the user info
    @PutMapping(value = "/users/{id}")
    User alterUser (@RequestBody User newusr, @PathVariable(value = "id") Long userId){
        User usr =  userRepository.findById(userId).get();
        usr.setFirstName(newusr.getFirstName());
        usr.setLastName(newusr.getLastName());
        usr.setEmail(newusr.getEmail());
        usr.setPassword(newusr.getPassword());
        return userRepository.save(usr);
    }
}
