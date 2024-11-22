package org.buccodev.gataway;

import org.buccodev.entity.User;
import org.buccodev.exceptions.ResourceNotFoundExcepiton;
import org.buccodev.gateway.UserGataway;
import org.buccodev.persistence.UserRepositoty;

import java.util.List;

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

    @Override
    public User findUserById(Long id) {
       var userEntity = userRepositoty.findById(id).orElseThrow(()-> new ResourceNotFoundExcepiton(id));
       return userMapper.toUser(userEntity);
    }

    @Override
    public void updateUser(Long id, User user) {
        var userEntity = userRepositoty.findById(id).orElseThrow(()-> new ResourceNotFoundExcepiton(id));
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setCpf(user.getCpf());
        userEntity.setPassword(user.getPassword());
        userEntity.setBirthday(user.getBirthday());
        userRepositoty.save(userEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        var user = userRepositoty.findById(id).orElseThrow(()-> new ResourceNotFoundExcepiton(id));
        if(user != null) {
            userRepositoty.deleteById(id);
        }
    }

    @Override
    public List<User> getAllUser() {

        var users = userRepositoty.findAll();

        return users.stream().map(userMapper::toUser).toList();
    }
}
