package com.mycompany.PropertyManagement.service;

import com.mycompany.PropertyManagement.dto.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
