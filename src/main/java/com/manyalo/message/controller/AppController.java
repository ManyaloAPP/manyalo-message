package com.manyalo.message.controller;

import com.manyalo.message.model.User;
import com.manyalo.message.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AppController {

    private final UserService userService;

    @PostMapping("/user")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAll() {
        return userService.getAll();
    }

}
