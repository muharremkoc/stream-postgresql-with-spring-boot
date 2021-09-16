package com.example.streamwithspringboot.service.stream;

import com.example.streamwithspringboot.model.User;
import com.example.streamwithspringboot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StreamServiceImpl implements StreamService {

      final UserRepository userRepository;


    @Override
    public Stream<User> filterUserByStartsWith(String value) {


        return  userRepository.findAll().stream().filter(user ->user.getName().startsWith(value));
    }

    @Override
    public List<User> foreachUsers() {

              List <User> newUsers=new ArrayList<User>();
             userRepository.findAll().stream().forEach(user -> {
                    user.setName(user.getName().toLowerCase(Locale.ROOT));
                    newUsers.add(user);
             });
      return newUsers;
    }

    @Override
    public List<User> collectUsersByFilterEndWith(String value) {
        return userRepository.findAll().stream().filter(user -> user.getName().endsWith(value)).collect(Collectors.toList());
    }

    @Override
    public Stream<Integer> mapWithUsersValues(int value) {


        return userRepository.findAll().stream().map(user -> user.getAge()+value);
    }

    @Override
    public Stream<User> anyOrAllMatchValueWithFilterUser(String value) {
        if (userRepository.findAll().stream().anyMatch(user -> user.getName().startsWith(value))){
            return userRepository.findAll().stream().filter(user ->user.getName().startsWith(value));
        }

        return null;
    }

    @Override
    public Optional<User> findFirstOrFindAnyUser() {
        return userRepository.findAll().stream().findAny();
    }

    @Override
    public Optional<User> reduceUsers() {
        return userRepository.findAll().stream().reduce((user, user2) -> user.getName().length()>user2.getName().length()?user:user2);
    }
}
