package com.manyalo.message.repository;

import com.manyalo.message.model.domain.University;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends R2dbcRepository<University, Long> {

}
