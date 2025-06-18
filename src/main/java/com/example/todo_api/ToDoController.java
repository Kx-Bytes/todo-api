package com.example.todo_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    // Get all todos
    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    // Get a todo by ID
    @GetMapping("/{id}")
    public Optional<ToDo> getTodoById(@PathVariable Long id) {
        return toDoRepository.findById(id);
    }

    // Create a new todo
    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo) {
        return toDoRepository.save(todo);
    }

    // Update an existing todo
    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable Long id, @RequestBody ToDo updatedTodo) {
        return toDoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return toDoRepository.save(todo);
        }).orElseGet(() -> {
            updatedTodo.setId(id);
            return toDoRepository.save(updatedTodo);
        });
    }

    // Delete a todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoRepository.deleteById(id);
    }
}