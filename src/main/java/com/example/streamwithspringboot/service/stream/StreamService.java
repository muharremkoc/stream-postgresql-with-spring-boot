package com.example.streamwithspringboot.service.stream;

import com.example.streamwithspringboot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface StreamService {

    Stream<User> filterUserByStartsWith(String value);
    List<User> foreachUsers();
    List<User> collectUsersByFilterEndWith(String value);
    Stream<Integer> mapWithUsersValues(int value);
    Stream<User> anyOrAllMatchValueWithFilterUser(String value);
    Optional<User> findFirstOrFindAnyUser();
    Optional<User> reduceUsers();
}
