package com.manyalo.message.service.impl;

import com.manyalo.message.model.api.request.FeedbackRequest;
import com.manyalo.message.model.api.response.FeedbackResponse;
import com.manyalo.message.model.domain.Feedback;
import com.manyalo.message.repository.FeedbackRepository;
import com.manyalo.message.service.FeedbackService;
import com.manyalo.message.util.constants.AppConstant;
import com.manyalo.message.util.mappers.FeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
	
	private final FeedbackRepository feedbackRepository;
	
	@Override
	public Mono<FeedbackResponse> saveFeedback(FeedbackRequest feedbackRequest) {
		Mono<Feedback> feedbackMono;
		if (feedbackRequest.user().userId() == AppConstant.USER_ID_GUEST) {
			feedbackMono = feedbackRepository.saveFeedbackWithUserGuest(
					feedbackRequest.user().userName(),
					feedbackRequest.user().email(),
					feedbackRequest.user().university().universityCode(),
					feedbackRequest.user().university().careers().careerCode(),
					feedbackRequest.message()
							.concat(AppConstant.FEEDBACK_DELIMITER_MESSAGE)
							.concat(feedbackRequest.courses().toString())
			);
		} else {
			feedbackMono = feedbackRepository.save(FeedbackMapper.mapFeedbackRequestToFeedback(feedbackRequest));
		}
		
		
		return feedbackMono.map(FeedbackMapper::mapFeedbackToFeedbackResponse);
		
	}
	
	@Override
	public Flux<FeedbackResponse> getAll() {
		return feedbackRepository.findAll()
				.map(FeedbackMapper::mapFeedbackToFeedbackResponse);
	}
}
