package com.kavinduakash.springs.service.impl;

import com.kavinduakash.springs.constant.ApplicationConstant;
import com.kavinduakash.springs.dto.UserDTO;
import com.kavinduakash.springs.entity.UserEntity;
import com.kavinduakash.springs.exception.UserException;
import com.kavinduakash.springs.repository.UserRepository;
import com.kavinduakash.springs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hp
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserDetails(String email) {
        try {
            Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
            if(!userEntityOptional.isPresent())
                throw new UserException(ApplicationConstant.USER_NOT_FOUND, "User not found");
            return new UserDTO(
                    userEntityOptional.get().getId(),
                    userEntityOptional.get().getName(),
                    userEntityOptional.get().getEmail(),
                    userEntityOptional.get().getUserRole(),
                    userEntityOptional.get().getUserStatus()
            );
        }catch (Exception e) {
            throw e;
        }
    }
}
