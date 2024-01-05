package com.biddan606.timeslot.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.biddan606.timeslot.mock.FakeUserRepository;
import com.biddan606.timeslot.user.service.command.UserCreateCommand;
import com.biddan606.timeslot.user.service.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void init() {
        UserRepository userRepository = new FakeUserRepository();
        userService = new UserService(userRepository, new UserMapper());
    }

    @DisplayName("유저를 생성한다.")
    @Test
    void create() {
        // given
        UserCreateCommand command = new UserCreateCommand(
                "loginId",
                "nickname",
                "password"
        );

        // when
        UserDto createdUserDtoDto = userService.create(command);

        // then
        assertAll(
                () -> assertThat(createdUserDtoDto.id()).isEqualTo(1L),
                () -> assertThat(createdUserDtoDto.loginId()).isEqualTo(command.loginId()),
                () -> assertThat(createdUserDtoDto.nickname()).isEqualTo(command.nickname())
        );
    }
}
