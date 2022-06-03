package com.mycompany.PropertyManagement.service.impl;

import com.mycompany.PropertyManagement.converter.UserConverter;
import com.mycompany.PropertyManagement.dto.UserDTO;
import com.mycompany.PropertyManagement.entity.UserEntity;
import com.mycompany.PropertyManagement.repository.UserRepository;
import com.mycompany.PropertyManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return null;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
