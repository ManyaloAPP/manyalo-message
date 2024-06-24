package com.manyalo.message.service;

import com.manyalo.message.model.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> getAll();

    Mono<User> save(User user);

}
