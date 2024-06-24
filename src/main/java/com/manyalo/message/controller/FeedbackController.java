package com.manyalo.message.controller;

import com.manyalo.message.model.api.request.FeedbackRequest;
import com.manyalo.message.model.api.response.FeedbackResponse;
import com.manyalo.message.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feedback")
@CrossOrigin(origins = "http://localhost:8081")
public class FeedbackController {
	
	private final FeedbackService feedbackService;
	
	@Transactional
	@PostMapping("/send")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<FeedbackResponse> create(@RequestBody FeedbackRequest feedbackRequest) {
		return feedbackService.saveFeedback(feedbackRequest);
	}
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public Flux<FeedbackResponse> getAll() {
		return feedbackService.getAll();
	}
}
