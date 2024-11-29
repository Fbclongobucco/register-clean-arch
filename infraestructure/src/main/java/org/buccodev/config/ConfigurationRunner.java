package org.buccodev.config;

import com.github.javafaker.Faker;
import org.buccodev.persistence.UserEntity;
import org.buccodev.persistence.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ConfigurationRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private UserRepositoty userRepositoty;

    @Override
    public void run(String... args) throws Exception {

        for (int i=0; i<50; i++){
            var user = new UserEntity(null, faker.name().fullName(), faker.internet().emailAddress(),
                    faker.number().digits(11), faker.internet().password()
                    .toString(), LocalDate.of(faker.number().numberBetween(1940, 2004),
                    faker.number().numberBetween(1,12), faker.number().numberBetween(1,30)));
            userRepositoty.save(user);
        }

    }
}
