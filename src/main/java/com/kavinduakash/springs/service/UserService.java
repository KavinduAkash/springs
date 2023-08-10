package com.kavinduakash.springs.service;

import com.kavinduakash.springs.dto.UserDTO;

/**
 * @author hp
 */
public interface UserService {
    public UserDTO getUserDetails(String email);
}
