package org.buccodev.gateway;

import org.buccodev.entity.User;

import java.util.List;

public interface UserGataway {

    User createUser(User user);
    User findUserById(Long id);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);
    List<User> getAllUser();

}
