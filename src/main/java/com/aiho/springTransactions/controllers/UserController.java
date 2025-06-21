package com.aiho.springTransactions.controllers;

import com.aiho.springTransactions.domain.Users;
import com.aiho.springTransactions.payLoad.UserPayLoad;
import com.aiho.springTransactions.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    private List<Users> users;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") long id){
       Users user= userService.getUser(id);
       return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserPayLoad userPayLoad){
        Users user = userService.createUser(userPayLoad);

        return ResponseEntity.ok(user);

    }

    @PutMapping("/{userId}")
    public Users updateUser(@PathVariable("userId") long id, @RequestBody UserPayLoad userPayLoad){
        Users user = users.stream().filter(u ->u.getId() ==id).findFirst().orElseThrow();

        user.setFirstName(userPayLoad.getFirstName());
        user.setLastName(userPayLoad.getLastName());
        user.setEmail(userPayLoad.getEmail());
        user.setPassword(userPayLoad.getPassword());
        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
       Users user= users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow();

        users.remove(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
