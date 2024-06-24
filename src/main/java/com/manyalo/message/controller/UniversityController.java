package com.manyalo.message.controller;

import com.manyalo.message.model.api.response.UniversityResponse;
import com.manyalo.message.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/university")
@CrossOrigin(origins = "http://localhost:8081")
public class UniversityController {
	
	private final UniversityService universityService;
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public Flux<UniversityResponse> getAll() {
		return universityService.retrieveUniversitiesWithCareers();
	}
	
}
