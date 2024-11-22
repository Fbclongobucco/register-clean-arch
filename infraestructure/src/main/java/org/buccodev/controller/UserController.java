package org.buccodev.controller;

import org.buccodev.controller.dto.UserRequestDto;
import org.buccodev.controller.dto.UserResponseDto;
import org.buccodev.controller.mapper.UserControllerMapper;
import org.buccodev.usecases.UserInterector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) throws URISyntaxException {
        var user = userControllerMapper.toUser(userRequestDto);
        var userSave = userInterector.createUser(user);

        UserResponseDto userResponseDto = userControllerMapper.toResponse(userSave);

        URI location = new URI("/users/" + userSave.getId());

        return ResponseEntity.created(location).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){
       var user = userInterector.findUserById(id);
       var userDto = userControllerMapper.toResponse(user);

       return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        var users = userInterector.getAllUser();
        var usersDtos = users.stream().map(userControllerMapper::toResponse).toList();

        return ResponseEntity.ok(usersDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
       userInterector.updateUser(id, userControllerMapper.toUser(userRequestDto));

       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userInterector.deleteUserById(id);
        return ResponseEntity.ok().build();
    }


}
