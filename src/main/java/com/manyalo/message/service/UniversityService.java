package com.manyalo.message.service;

import com.manyalo.message.model.api.response.UniversityResponse;
import reactor.core.publisher.Flux;

public interface UniversityService {
	
	Flux<UniversityResponse> retrieveUniversitiesWithCareers();
	
}
