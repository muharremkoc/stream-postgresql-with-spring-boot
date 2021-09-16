package com.example.streamwithspringboot.controller;

import com.example.streamwithspringboot.model.User;
import com.example.streamwithspringboot.model.UserDTO;
import com.example.streamwithspringboot.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

      @PostMapping(value = "user")
    public User createUser(@RequestBody @Valid User user){
          return userService.createUser(user);
      }
      @PutMapping(value = "/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){
          return userService.updateUser(id, userDTO);
      }

      @DeleteMapping(value = "/user{id}")
    public void deleteUser(@PathVariable("id") Long id){
           userService.deleteUser(id);
      }
      @GetMapping(value = "/users")
    public List<User> getUsers(){
         return userService.getUsers();
      }
      @GetMapping(value = "/user/{id}")
    public Optional<User>getUser(@PathVariable("id") Long id){
          return userService.getUser(id);
      }
}
