package org.buccodev.gataway;

import org.buccodev.entity.User;
import org.buccodev.persistence.UserEntity;

public class UserMapper {

    public User toUser(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(),
                userEntity.getCpf(), userEntity.getPassword(), userEntity.getBirthday());
    }

    public UserEntity toUseEntity(User user){
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getCpf(), user.getPassword(), user.getBirthday());
    }
}
