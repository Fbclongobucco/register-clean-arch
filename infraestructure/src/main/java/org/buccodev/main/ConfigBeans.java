package org.buccodev.main;

import com.github.javafaker.Faker;
import org.buccodev.controller.mapper.UserControllerMapper;
import org.buccodev.gataway.UserMapper;
import org.buccodev.gataway.UserRepositoryGateway;
import org.buccodev.gateway.UserGataway;
import org.buccodev.persistence.UserRepositoty;
import org.buccodev.usecases.UserInterector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class ConfigBeans {

    @Bean
    UserInterector userInterector(UserGataway userGataway){
        return new UserInterector(userGataway);
    }

    @Bean
    UserGataway userGataway(UserMapper userMapper, UserRepositoty userRepositoty){
        return new UserRepositoryGateway(userMapper, userRepositoty);
    }

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    UserControllerMapper userControllerMapper(){
       return new UserControllerMapper();
    }

    @Bean
    Faker faker(){
        return new Faker(new Locale("pt-BR"));
    }

}
