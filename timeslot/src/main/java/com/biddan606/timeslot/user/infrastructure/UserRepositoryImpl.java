package com.biddan606.timeslot.user.infrastructure;

import com.biddan606.timeslot.user.domain.User;
import com.biddan606.timeslot.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJapRepository userJapRepository;

    @Override
    public User save(User user) {
        return userJapRepository.save(UserEntity.from(user))
                .toModel();
    }
}
