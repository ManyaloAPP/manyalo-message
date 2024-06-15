package com.manyalo.message.service;

import com.manyalo.message.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> getAll();

    public Mono<User> save(User user);

}
