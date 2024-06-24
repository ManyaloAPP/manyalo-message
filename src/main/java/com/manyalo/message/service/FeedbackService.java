package com.manyalo.message.service;

import com.manyalo.message.model.api.request.FeedbackRequest;
import com.manyalo.message.model.api.response.FeedbackResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackService {
	Mono<FeedbackResponse> saveFeedback(FeedbackRequest feedbackRequest);
	Flux<FeedbackResponse> getAll();
}
