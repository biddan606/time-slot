package com.biddan606.timeslot.user.domain;

import org.apache.commons.lang3.StringUtils;

public record Password(
        String value
) {

    public Password {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("비밀번호는 null이거나 빈 값일 수 없습니다.");
        }
    }
}
