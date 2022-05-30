package com.example.NationalEquestrianFederation.mapper;

import com.example.NationalEquestrianFederation.dto.UserDto;
import com.example.NationalEquestrianFederation.model.User;

public class UserMapper {

    public static User convertToUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

}
