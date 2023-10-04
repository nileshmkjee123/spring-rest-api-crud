package com.example.springrest.service;

import com.example.springrest.dto.UserDto;
import com.example.springrest.entity.User;
import com.example.springrest.exception.EmailAlreadyExistsException;
import com.example.springrest.exception.ResourceNotFoundException;
import com.example.springrest.mapper.UserMapper;
import com.example.springrest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //UserDTO into jpa entity
//        User user1 = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists for user.");
        }
        User user1 = modelMapper.map(userDto,User.class);
        User savedUser = userRepository.save(user1);
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        System.out.println( savedUser.getId()+","+ savedUser.getFirstName()+","+
                savedUser.getLastName()+","+savedUser.getEmail());
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
       User user =userRepository.findById(userId).orElseThrow(
               ()-> new ResourceNotFoundException("User","id",userId)
       );
        //User user = optionalUser.get();
//        return UserMapper.mapToUserDto(user);
        return modelMapper.map(user,UserDto.class);

    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = userRepository.findAll();

//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream().map((user -> modelMapper.map(user,UserDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User","id",user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        userRepository.deleteById(userId);
    }

}
