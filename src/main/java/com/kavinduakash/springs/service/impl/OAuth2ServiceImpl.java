package com.kavinduakash.springs.service.impl;

import com.kavinduakash.springs.entity.UserEntity;
import com.kavinduakash.springs.enums.UserStatus;
import com.kavinduakash.springs.exception.CustomOauthException;
import com.kavinduakash.springs.repository.UserRepository;
import com.kavinduakash.springs.service.OAuth2Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author hp
 */
@Log4j2
@Service(value = "userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OAuth2ServiceImpl implements OAuth2Service, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public OAuth2ServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<UserEntity> byEmail = userRepository.findByEmail(username);
            if(!byEmail.isPresent()) throw new CustomOauthException("Invalid Credentials");
            if(byEmail.get().getUserStatus().equals(UserStatus.DELETED)) throw new CustomOauthException("Invalid Credentials");
            return new org.springframework.security.core.userdetails.User(byEmail.get().getEmail(), byEmail.get().getPassword(),
                    getAuthority((byEmail.get().getUserRole().toString())));
        } catch(Exception e) {
            throw e;
        }
    }

    private List<SimpleGrantedAuthority> getAuthority(String roleName) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
    }
}
