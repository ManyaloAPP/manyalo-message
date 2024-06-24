package com.manyalo.message.model.api.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FeedbackRequest(UserRequest user, @NotNull(message = "courses cannot be null") List<String> courses,
							  @NotNull(message = "message cannot be null") String message) {
	
}