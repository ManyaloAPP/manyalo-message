package com.manyalo.message.util.mappers;

import com.manyalo.message.model.api.response.UniversityResponse;
import com.manyalo.message.model.dao.UniversityWithCareers;
import reactor.core.publisher.Flux;

public class UniversityMapper {
	
	public static Flux<UniversityResponse> mapUniversityWithCareers(Flux<UniversityWithCareers> universityWithCareers) {
		return universityWithCareers
				.groupBy(UniversityWithCareers::universityId)
				.flatMap(group -> group.collectList().map(careers ->
						mapUniversityWithCareers(careers.get(0))
								.careers(careers.stream().parallel()
										.map(career -> UniversityResponse.Careers.builder()
												.careerCode(career.careerId())
												.careerName(career.careerName())
												.build())
										.toList())
								.build()
				));
	}
	
	public static UniversityResponse.UniversityResponseBuilder mapUniversityWithCareers(UniversityWithCareers universityWithCareers) {
		return UniversityResponse.builder()
				.universityCode(universityWithCareers.universityId())
				.universityName(universityWithCareers.universityName());
	}
	
}
