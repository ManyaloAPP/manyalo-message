package com.manyalo.message.service.impl;

import com.manyalo.message.model.domain.User;
import com.manyalo.message.repository.UserRepository;
import com.manyalo.message.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository;

    @Override
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

}
