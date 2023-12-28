package com.biddan606.timeslot.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.biddan606.timeslot.mock.FakeUserRepository;
import com.biddan606.timeslot.user.service.command.UserCreateCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;
    private FakeUserRepository fakeUserRepository;

    @BeforeEach
    void init() {
        fakeUserRepository = new FakeUserRepository();
        userService = new UserService(fakeUserRepository, new UserMapper());
    }

    @AfterEach
    void cleanup() {
        fakeUserRepository.deleteAll();
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
        Long createdUserId = userService.create(command);

        // then
        assertThat(createdUserId).isEqualTo(1L);
    }
}
