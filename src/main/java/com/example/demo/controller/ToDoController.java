package com.example.demo.controller;

import com.example.demo.model.ToDo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String home(Model model, Principal principal) {
        if (principal == null) return "redirect:/login";
        model.addAttribute("username", principal.getName());
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("todos", toDoService.getTodosByUser(user));
        model.addAttribute("newTodo", new ToDo());
        
    return "index";
}

    @PostMapping("/add")
    public String addTodo(@ModelAttribute ToDo todo, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        todo.setUser(user);
        toDoService.saveTodo(todo);
        return "redirect:/?success";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("todo", new ToDo());
        return "add"; // akan render add.html
}


    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, Principal principal) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        todo.ifPresent(t -> {
            if (t.getUser().getUsername().equals(principal.getName())) {
                toDoService.deleteTodo(id);
            }
        });
        return "redirect:/?deleted";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, Principal principal) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        todo.ifPresent(t -> {
            if (t.getUser().getUsername().equals(principal.getName())) {
                t.setCompleted(!t.isCompleted());
                toDoService.saveTodo(t);
            }
        });
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, Principal principal) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        if (todo.isPresent() && todo.get().getUser().getUsername().equals(principal.getName())) {
            model.addAttribute("todo", todo.get());
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateTodoForm(@PathVariable Long id, @ModelAttribute("todo") ToDo updatedTodo, Principal principal) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        if (todo.isPresent() && todo.get().getUser().getUsername().equals(principal.getName())) {
            ToDo existing = todo.get();
            existing.setTask(updatedTodo.getTask());
            toDoService.saveTodo(existing);
        }
        return "redirect:/";
    }
}
