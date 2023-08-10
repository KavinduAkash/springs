package com.kavinduakash.springs.entity;

import com.kavinduakash.springs.enums.UserRole;
import com.kavinduakash.springs.enums.UserStatus;
import lombok.*;

import javax.persistence.*;

/**
 * @author hp
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255)
    private String  name;
    @Column(length = 255, nullable = false, unique = true)
    private String  email;
    @Column(length = 255, nullable = false)
    private String  password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
