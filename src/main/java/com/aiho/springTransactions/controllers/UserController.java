package com.aiho.springTransactions.controllers;

import com.aiho.springTransactions.domain.User;
import com.aiho.springTransactions.payLoad.UserPayLoad;
import com.aiho.springTransactions.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    private List<User> users;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id){
       User user= userService.getUser(id);
       return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserPayLoad userPayLoad){
        User user = userService.createUser(userPayLoad);

        return ResponseEntity.ok(user);

    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") long id, @RequestBody UserPayLoad userPayLoad){
        return userService.updateUser(id, userPayLoad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
