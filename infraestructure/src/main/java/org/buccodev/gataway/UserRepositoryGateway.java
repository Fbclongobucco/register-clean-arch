package org.buccodev.gataway;

import org.buccodev.entity.User;
import org.buccodev.gateway.UserGataway;
import org.buccodev.persistence.UserRepositoty;

public class UserRepositoryGateway implements UserGataway {

    private final UserMapper userMapper;
    private final UserRepositoty userRepositoty;

    public UserRepositoryGateway(UserMapper userMapper, UserRepositoty userRepositoty) {
        this.userMapper = userMapper;
        this.userRepositoty = userRepositoty;
    }


    @Override
    public User createUser(User user) {
        var userEntity = userMapper.toUseEntity(user);
        var userSave = userRepositoty.save(userEntity);
        return userMapper.toUser(userSave);
    }
}
