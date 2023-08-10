package com.kavinduakash.springs.config;

import com.kavinduakash.springs.dto.UserDTO;
import com.kavinduakash.springs.service.OAuth2Service;
import com.kavinduakash.springs.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {
    //    private static final Logger LOGGER = LogManager.getLogger(CustomTokenEnhancer.class);
    private final OAuth2Service oauth2UserService;
    private final HttpServletRequest request;
    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    @Autowired
    public CustomTokenEnhancer(OAuth2Service oauth2UserService, HttpServletRequest request, BCryptPasswordEncoder encoder, UserService userService) {
        this.oauth2UserService = oauth2UserService;
        this.request = request;
        this.encoder = encoder;
        this.userService = userService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        log.info("Start: CustomTokenEnhancer enhance");

        final Map<String, Object> additionalInfo = new HashMap<>();

        User user = (User) oAuth2Authentication.getPrincipal();
        log.info("Execute: CustomTokenEnhancer enhance user name : " + user.getUsername());

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User account = (User) authentication.getPrincipal();

        UserDTO userDetails = userService.getUserDetails(user.getUsername());
        additionalInfo.put("user", userDetails);

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        // set custom claims
        return super.enhance(oAuth2AccessToken, oAuth2Authentication);
    }

}
