package com.biddan606.timeslot.user.controller.request;

import com.biddan606.timeslot.user.service.command.UserCreateCommand;

public record UserCreateRequest(
        String loginId,
        String nickname,
        String password
) {

    public UserCreateCommand toCommand() {
        return new UserCreateCommand(loginId, nickname, password);
    }
}
