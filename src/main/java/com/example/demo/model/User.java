package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ToDo> todos;

    // Constructors
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<ToDo> getTodos() { return todos; }

    public void setTodos(List<ToDo> todos) { this.todos = todos; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

}
