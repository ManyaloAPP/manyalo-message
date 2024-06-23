package com.manyalo.message.model.api.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UniversityResponse {
	Integer universityCode;
	String universityName;
	List<Careers> careers;
	
	@Builder
	public record Careers(
			int careerCode, String careerName) {
	}
}
