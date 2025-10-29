package com.example.Giftora.controllers;

import com.example.Giftora.entities.User;
import com.example.Giftora.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){ this.userService=userService; }

    @PostMapping
    public User createUser(@RequestBody User user){ return userService.saveUser(user); }

    @GetMapping
    public List<User> getUsers(){ return userService.getAllUsers(); }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){ return userService.getByEmail(email); }
}