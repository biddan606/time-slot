package com.biddan606.timeslot.user.service.port;

import com.biddan606.timeslot.user.domain.User;

public interface UserRepository {

    User save(User user);
}
