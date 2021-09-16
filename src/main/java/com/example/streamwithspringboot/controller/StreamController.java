package com.example.streamwithspringboot.controller;

import com.example.streamwithspringboot.model.User;
import com.example.streamwithspringboot.service.stream.StreamService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/stream")
public class StreamController {

    final StreamService streamService;

    @GetMapping(value = "/filter")
    public Stream<User> streamFilter(@RequestParam String value) {
        return  streamService.filterUserByStartsWith( value);
    }
    @GetMapping(value = "/forEach")
    public List<User> forEach() {
        return streamService.foreachUsers();
    }
    @GetMapping(value = "/collect")
    public List<User> collect(@RequestParam String value) {
        return streamService.collectUsersByFilterEndWith(value);
    }
    @GetMapping(value = "/map")
    public Stream<Integer> map(@RequestParam int value) {
        return streamService.mapWithUsersValues(value);
    }
    @GetMapping(value = "/match")
    public Stream<User> allOrAnyMatch(@RequestParam String value) {
        return streamService.anyOrAllMatchValueWithFilterUser(value);
    }
    @GetMapping(value = "/first")
    public Optional<User> findFirstOrAnyUser() {
        return streamService.findFirstOrFindAnyUser();
    }
    @GetMapping(value = "/reduce")
    public Optional<User> reduce() {
        return streamService.reduceUsers();
    }
}
