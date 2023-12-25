package com.biddan606.timeslot.user.domain;

import org.apache.commons.lang3.StringUtils;

public record Nickname(
        String value
) {

    public Nickname {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("닉네임은 null이거나 빈 값일 수 없습니다.");
        }
    }
}
