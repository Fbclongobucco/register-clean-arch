package org.buccodev.controller.mapper;

import org.buccodev.controller.dto.UserRequestDto;
import org.buccodev.controller.dto.UserResponseDto;
import org.buccodev.entity.User;

public class UserControllerMapper {

    public UserResponseDto toResponse(User user){
        return new UserResponseDto(user.getName(), user.getEmail(), user.getCpf(), user.getBirthday());
    }

    public User toUser(UserRequestDto userRequestDto){
        return new User(null, userRequestDto.name(), userRequestDto.email(), userRequestDto.cpf(), userRequestDto.password(), userRequestDto.birthday());
    }


}
