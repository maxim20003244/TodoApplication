package com.example.mycompany.todoapplication.controller;

import com.example.mycompany.todoapplication.model.Todo;
import com.example.mycompany.todoapplication.service.TodoService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {
private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/list-todo")
    public String getListOfTodo (Model model, Authentication authentication){
        List<Todo> todo = todoService.findAllMessage();

        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", authentication.getAuthorities().toString());
        model.addAttribute("todo" ,todo);
        return "todo-list";
    }

    @RequestMapping(value = {"/add-todo"})
    public ModelAndView showAddTodoPage (@ModelAttribute("todo") Todo todo, ModelAndView modelAndView){
          modelAndView.setViewName("add-todo");
        return modelAndView;
    }

    @RequestMapping (value = {"/save-todo"} , method = RequestMethod.POST)
    public String saveMessages(@ModelAttribute("todo") Todo todo){
            todoService.saveMessage(todo);
            return "redirect:/list-todo";
    }

    @RequestMapping(value = {"delete-todo"})
    public String deleteBuyId(@RequestParam int id){
        todoService.deleteBuId(id);
        return "redirect:/list-todo";
    }
    @RequestMapping(value = {"/edit-todo"} , method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id,Model model ){
       Todo todo = todoService.getTodoBuyId(id);
      model.addAttribute("todo",todo);
      return "update-todo";

    }
    @RequestMapping(value = "/save-editTodo", method = RequestMethod.POST )
    public String saveEditTodo(Todo todo){
    todoService.updateTodo(todo);
    return "redirect:/list-todo";
    }


}
