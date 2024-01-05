package com.biddan606.timeslot.user.controller.response;

import com.biddan606.timeslot.user.service.UserDto;
import lombok.Builder;

@Builder
public record UserCreateResponse(
        Long userId
) {

    public static UserCreateResponse from(UserDto user) {
        return UserCreateResponse.builder()
                .userId(user.id())
                .build();
    }
}
