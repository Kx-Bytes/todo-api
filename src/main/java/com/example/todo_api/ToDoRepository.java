package com.example.todo_api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // No extra methods needed for now — JPA gives you:
    // - findAll()
    // - save()
    // - deleteById()
    // - findById()
}