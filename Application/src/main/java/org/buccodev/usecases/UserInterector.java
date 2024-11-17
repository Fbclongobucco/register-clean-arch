package org.buccodev.usecases;

import org.buccodev.entity.User;
import org.buccodev.gateway.UserGataway;

public class UserInterector {

    private final UserGataway userGataway;


    public UserInterector(UserGataway userGataway) {
        this.userGataway = userGataway;
    }

    public User createUser(User user){
        return this.userGataway.createUser(user);
    }
}
