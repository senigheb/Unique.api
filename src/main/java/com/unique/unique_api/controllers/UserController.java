package com.unique.unique_api.controllers;

import com.unique.unique_api.controllers.dto.UserDTO;
import com.unique.unique_api.service.UserService;
import com.unique.unique_api.repositories.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/add")
    public User createUser(@RequestBody UserDTO newUserDTO){ return userService.save(newUserDTO); }


    @GetMapping("/find")
    public User findUserByName(@RequestParam String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer userId){
        return userService.findById(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Integer userId){
        return userService.update(userDTO, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer userId){
        userService.delete(userId);
    }



}
