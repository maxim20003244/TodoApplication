package com.example.mycompany.todoapplication.repository;

import com.example.mycompany.todoapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getByRoleName(String name);
}
