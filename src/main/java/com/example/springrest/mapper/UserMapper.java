package com.example.springrest.mapper;

import com.example.springrest.dto.UserDto;
import com.example.springrest.entity.User;

public class UserMapper {
    //convert use jpa entity to user dto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
          user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    //convert userdto into user jpa entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
