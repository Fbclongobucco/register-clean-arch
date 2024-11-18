package org.buccodev.gataway;

import org.buccodev.entity.User;
import org.buccodev.persistence.UserEntity;
import org.buccodev.persistence.UserRepositoty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryGatewayTest {


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void creatingAUserAndReturningThatUser() {
    }



    private void startUser(){
    User user = new User(1L, "John Doe", "johndoe@gmail.com", "12345678950", "123", LocalDate.now());
    UserEntity userEntity = new UserEntity(1L, "John Doe", "johndoe@gmail.com", "12345678950", "123", LocalDate.now());
    }
}