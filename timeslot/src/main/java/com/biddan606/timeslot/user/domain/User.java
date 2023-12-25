package com.biddan606.timeslot.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private final Long id;
    private final LoginId loginId;
    private final Nickname nickname;
    private final Password password;

    @Builder
    private User(Long id, String loginId, String nickname, String password) {
        this.id = id;
        this.loginId = new LoginId(loginId);
        this.nickname = new Nickname(nickname);
        this.password = new Password(password);
    }
}
