package com.biddan606.timeslot.user.domain;

import org.apache.commons.lang3.StringUtils;

public record LoginId(
        String value
) {

    public LoginId {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("로그인 ID는 null이거나 빈 값일 수 없습니다.");
        }
    }
}
