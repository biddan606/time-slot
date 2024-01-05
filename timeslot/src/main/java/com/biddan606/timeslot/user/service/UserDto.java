package com.biddan606.timeslot.user.service;

import com.biddan606.timeslot.user.domain.User;
import lombok.Builder;

@Builder
public record UserDto(
        Long id,
        String loginId,
        String nickname
) {

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .loginId(user.getLoginId().value())
                .nickname(user.getNickname().value())
                .build();
    }
}
