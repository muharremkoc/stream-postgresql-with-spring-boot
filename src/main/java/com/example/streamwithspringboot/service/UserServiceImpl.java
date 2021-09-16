package com.example.streamwithspringboot.service;

import com.example.streamwithspringboot.exception.UserAlreadyExistsException;
import com.example.streamwithspringboot.exception.UserNotFoundException;
import com.example.streamwithspringboot.model.User;
import com.example.streamwithspringboot.model.UserDTO;
import com.example.streamwithspringboot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> optionalUser=userRepository.findById(user.getId());

        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }



        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDTO user) {
        User newUser=userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setMail(user.getMail());


        return userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());


        userRepository.delete(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> streamUser=userRepository.findAll();
        return streamUser;
    }

    @Override
    public Optional<User> getUser(Long id) {
        Optional<User> emp = userRepository.findById(id);
        return emp;
    }
}
