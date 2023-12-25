package com.biddan606.timeslot.user.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NicknameTest {

    @DisplayName("null 또는 빈 값으로 객체를 생성할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void shouldNotCreate_emptyValue(String nullOrEmptyValue) {
        // when // then
        assertThatThrownBy(() -> new Nickname(nullOrEmptyValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("닉네임은 null이거나 빈 값일 수 없습니다.");
    }

    @DisplayName("객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, q, 1qwe, qwe1, login@@@"})
    void create(String value) {
        // when // then
        assertThatCode(() -> new Nickname(value))
                .doesNotThrowAnyException();
    }

}
