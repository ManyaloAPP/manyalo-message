package com.manyalo.message.model.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public record UserRequest(@NotNull(message = "User ID cannot be null") Long userId, String userName,
						  @Email(message = "Email should be valid") String email,
						  com.manyalo.message.model.api.request.UserRequest.University university) {
	
	public record University(
			@NotNull(message = "University code cannot be null") int universityCode,
			@NotNull Careers careers) {
		public record Careers(
				@NotNull(message = "Career code cannot be null") int careerCode) {
		}
	}
	
}
