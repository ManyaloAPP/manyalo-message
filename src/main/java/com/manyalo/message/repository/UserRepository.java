package com.manyalo.message.repository;

import com.manyalo.message.model.domain.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<User,Long> {
}
