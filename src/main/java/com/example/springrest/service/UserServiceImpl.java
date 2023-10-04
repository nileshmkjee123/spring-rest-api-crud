package com.example.springrest.service;

import com.example.springrest.dto.UserDto;
import com.example.springrest.entity.User;
import com.example.springrest.mapper.UserMapper;
import com.example.springrest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        //UserDTO into jpa entity
        User user1 = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user1);
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        System.out.println( savedUser.getId()+","+ savedUser.getFirstName()+","+
                savedUser.getLastName()+","+savedUser.getEmail());
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser =userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
