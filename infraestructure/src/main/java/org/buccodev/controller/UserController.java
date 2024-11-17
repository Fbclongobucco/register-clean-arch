package org.buccodev.controller;

import org.buccodev.controller.dto.UserRequestDto;
import org.buccodev.controller.dto.UserResponseDto;
import org.buccodev.controller.mapper.UserControllerMapper;
import org.buccodev.usecases.UserInterector;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserInterector userInterector;
    private final UserControllerMapper userControllerMapper;


    public UserController(UserInterector userInterector, UserControllerMapper userControllerMapper) {
        this.userInterector = userInterector;
        this.userControllerMapper = userControllerMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        var user = userControllerMapper.toUser(userRequestDto);
        var userSave = userInterector.createUser(user);

        return ResponseEntity.ok(userControllerMapper.toResponse(userSave));
    }


}
