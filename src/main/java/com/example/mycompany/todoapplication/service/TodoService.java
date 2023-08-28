package com.example.mycompany.todoapplication.service;

import com.example.mycompany.todoapplication.model.Todo;
import com.example.mycompany.todoapplication.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public boolean saveMessage (Todo todo) {
        boolean isSaved = false;
        Todo save = todoRepository.save(todo);
        if(null != save && todo.getDescription() != null && !todo.getDescription().isEmpty() ){
            isSaved = true;

        }
      return  isSaved;
    }

    public List<Todo> findAllMessage (){
       List<Todo> msg =  todoRepository.findAll();
       return msg;
    }

    public void deleteBuId(int id){
        todoRepository.deleteById(id);
    }

    public Todo getTodoBuyId(Integer id){
       Todo todo = todoRepository.findById(id).get();

       return  todo;
    }

    public void updateTodo(Todo todo){
        deleteBuId(todo.getId());
        String description = todo.getDescription();
        todo.setDescription(description);
        todoRepository.save(todo);



    }
}
