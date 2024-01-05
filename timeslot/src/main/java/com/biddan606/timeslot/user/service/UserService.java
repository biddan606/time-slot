package com.biddan606.timeslot.user.service;

import com.biddan606.timeslot.user.domain.User;
import com.biddan606.timeslot.user.service.command.UserCreateCommand;
import com.biddan606.timeslot.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto create(UserCreateCommand command) {
        User user = userMapper.toUser(command);

        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
    }
}
