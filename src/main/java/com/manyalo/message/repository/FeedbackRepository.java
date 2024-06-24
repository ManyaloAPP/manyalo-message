package com.manyalo.message.repository;

import com.manyalo.message.model.domain.Feedback;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FeedbackRepository extends R2dbcRepository<Feedback,Long> {

	@Query("CALL manyalo_db.sp_create_user_guest_with_feedback" +
			"(:name_user,:email_user,:university,:career,:message_user)")
	Mono<Feedback> saveFeedbackWithUserGuest(String name_user, String email_user, int university, int career, String message_user);

}
