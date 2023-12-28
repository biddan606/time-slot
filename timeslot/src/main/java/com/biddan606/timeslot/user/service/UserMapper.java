package com.biddan606.timeslot.user.service;

import com.biddan606.timeslot.user.domain.User;
import com.biddan606.timeslot.user.service.command.UserCreateCommand;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserCreateCommand param) {
        return User.builder()
                .loginId(param.loginId())
                .nickname(param.nickname())
                .password(param.password())
                .build();
    }
}
