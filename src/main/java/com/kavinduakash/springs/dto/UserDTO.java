package com.kavinduakash.springs.dto;

import com.kavinduakash.springs.enums.UserRole;
import com.kavinduakash.springs.enums.UserStatus;
import lombok.*;

/**
 * @author hp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private UserRole userRole;
    private UserStatus userStatus;
}
