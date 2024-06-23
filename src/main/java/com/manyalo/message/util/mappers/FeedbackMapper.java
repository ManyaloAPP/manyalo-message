package com.manyalo.message.util.mappers;

import com.manyalo.message.model.api.request.FeedbackRequest;
import com.manyalo.message.model.api.response.FeedbackResponse;
import com.manyalo.message.model.domain.Feedback;
import com.manyalo.message.util.constants.AppConstant;

import java.time.LocalDateTime;

public class FeedbackMapper {
	
	public static Feedback mapFeedbackRequestToFeedback(FeedbackRequest feedbackRequest) {
		return Feedback.builder()
				.message(feedbackRequest.message()
						.concat(AppConstant.FEEDBACK_DELIMITER_MESSAGE)
						.concat(feedbackRequest.courses().toString()))
				.userId(feedbackRequest.user().userId())
				.timeStamp(LocalDateTime.now())
				.build();
	}
	
	public static FeedbackResponse mapFeedbackToFeedbackResponse(Feedback feedback) {
		return FeedbackResponse.builder()
				.message(feedback.getMessage())
				.timeStamp(feedback.getTimeStamp())
				.build();
	}
	
}
