package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.User;

public interface IUserService {

    User findByUsername(String username);

    User register(User user);

}
