package com.manyalo.message.util.mappers;

import com.manyalo.message.model.api.request.UserRequest;
import com.manyalo.message.model.domain.User;
import com.manyalo.message.util.constants.AppConstant;

public class UserMapper {
	
	public static User mapUserRequestToUser(UserRequest userRequest) {
		return User.builder()
				.userId(userRequest.userId())
				.userName(userRequest.userName())
				.email(userRequest.email())
				.universityCode(userRequest.university().universityCode())
				.careersCode(userRequest.university().careers().careerCode())
				.status(AppConstant.USER_STATUS_INACTIVE)
				.type(AppConstant.USER_TYPE_GUEST)
				.build();
	}
}
