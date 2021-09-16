package com.example.streamwithspringboot.service;

import com.example.streamwithspringboot.model.User;
import com.example.streamwithspringboot.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id, UserDTO user);
    void deleteUser(Long id);
    List<User> getUsers();
    Optional<User> getUser(Long id);
}
