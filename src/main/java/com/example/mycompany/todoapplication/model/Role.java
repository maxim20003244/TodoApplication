package com.example.mycompany.todoapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int roleId;

    private String roleName;
}
