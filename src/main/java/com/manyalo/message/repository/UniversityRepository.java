package com.manyalo.message.repository;

import com.manyalo.message.model.domain.University;
import com.manyalo.message.model.dao.UniversityWithCareers;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UniversityRepository extends R2dbcRepository<University, Long> {
	@Query("CALL manyalo_db.get_universities_with_careers()")
	Flux<UniversityWithCareers> getUniversitiesWithCareers();
}
