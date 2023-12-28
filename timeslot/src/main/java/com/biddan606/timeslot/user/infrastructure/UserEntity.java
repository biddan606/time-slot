package com.biddan606.timeslot.user.infrastructure;

import com.biddan606.timeslot.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    private String nickname;

    private String password;

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.loginId = user.getLoginId().value();
        userEntity.nickname = user.getNickname().value();
        userEntity.password = user.getPassword().value();

        return userEntity;
    }

    public User toModel() {
        return User.builder()
                .id(id)
                .loginId(loginId)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
