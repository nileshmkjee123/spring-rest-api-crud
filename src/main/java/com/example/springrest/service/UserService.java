package com.example.springrest.service;

import com.example.springrest.dto.UserDto;
import com.example.springrest.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);
    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
