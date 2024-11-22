package org.buccodev.usecases;

import org.buccodev.entity.User;
import org.buccodev.gateway.UserGataway;

import java.util.List;

public class UserInterector {

    private final UserGataway userGataway;


    public UserInterector(UserGataway userGataway) {
        this.userGataway = userGataway;
    }

    public User createUser(User user){
        return this.userGataway.createUser(user);
    }

    public User findUserById(Long id){
        return this.userGataway.findUserById(id);
    }

    public void updateUser(Long id, User user){
        this.userGataway.updateUser(id, user);
    }
    public void deleteUserById(Long id){
        this.userGataway.deleteUserById(id);
    }
    public List<User> getAllUser(){
        return this.userGataway.getAllUser();
    }
}
