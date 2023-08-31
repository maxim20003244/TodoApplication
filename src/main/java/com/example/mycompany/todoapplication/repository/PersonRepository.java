package com.example.mycompany.todoapplication.repository;

import com.example.mycompany.todoapplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
    Person readByEmail(String email);
}
