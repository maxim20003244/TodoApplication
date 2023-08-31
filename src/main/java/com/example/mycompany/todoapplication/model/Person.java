package com.example.mycompany.todoapplication.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String name;
    private String mobileNumber;

    private String email;
    private String confirmEmail;

    private String password;
    private String confirmPassword;
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinColumn(name = "role_id" ,referencedColumnName = "roleId", nullable = false)
    private Role role;

}
