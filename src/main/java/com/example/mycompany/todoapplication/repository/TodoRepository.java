package com.example.mycompany.todoapplication.repository;

import com.example.mycompany.todoapplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository  extends JpaRepository<Todo,Integer> {

}
