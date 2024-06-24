package com.manyalo.message.service.impl;

import com.manyalo.message.model.api.response.UniversityResponse;
import com.manyalo.message.model.dao.UniversityWithCareers;
import com.manyalo.message.repository.UniversityRepository;
import com.manyalo.message.service.UniversityService;
import com.manyalo.message.util.mappers.UniversityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
	
	private final UniversityRepository universityRepository;
	
	@Override
	public Flux<UniversityResponse> retrieveUniversitiesWithCareers() {
		Flux<UniversityWithCareers> universityWithCareers = universityRepository.getUniversitiesWithCareers();
		return UniversityMapper.mapUniversityWithCareers(universityWithCareers);
	}
}
