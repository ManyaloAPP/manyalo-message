package com.manyalo.message.model.api.response;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;


@Value
@Builder
public class FeedbackResponse {
	String message;
	LocalDateTime timeStamp;
}
