package com.biddan606.timeslot.user.service.command;

import org.apache.commons.lang3.StringUtils;

public record UserCreateCommand(
        String loginId,
        String nickname,
        String password
) {

    public UserCreateCommand {
        if (StringUtils.isBlank(loginId)) {
            throw new IllegalArgumentException("유저 생성 시 로그인 ID는 null이거나 빈 값일 수 없습니다.");
        }

        if (StringUtils.isBlank(nickname)) {
            throw new IllegalArgumentException("유저 생성 시 닉네임은 null이거나 빈 값일 수 없습니다.");
        }

        if (StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("유저 생성 시 비밀번호는 null이거나 빈 값일 수 없습니다.");
        }
    }


}
