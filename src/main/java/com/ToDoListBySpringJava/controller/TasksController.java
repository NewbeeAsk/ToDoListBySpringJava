package com.ToDoListBySpringJava.controller;

import com.ToDoListBySpringJava.exeption.NotFoundException;
import com.ToDoListBySpringJava.models.ToDoPoint;
import com.ToDoListBySpringJava.models.User;
import com.ToDoListBySpringJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private final UserRepository userRepository;

    public TasksController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public List<ToDoPoint> getTasksByUserId(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        return user.getToDoPoints();
    }

    @CrossOrigin
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @CrossOrigin
    @PostMapping("{id}")
    public ToDoPoint createPost(@PathVariable Integer id, @RequestBody ToDoPoint toDoPoint) {
        User user = userRepository.findById(id).orElseThrow();
        user.getToDoPoints().add(toDoPoint);
        userRepository.save(user);
        return toDoPoint;
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/users/{userId}/{taskId}")
    public void deleteTask(@PathVariable Integer userId, @PathVariable Integer taskId) {
        System.out.println(taskId);
        System.out.println(userId);
        User user = userRepository.findById(userId).orElseThrow();
        user.getToDoPoints().removeIf(toDoPoint -> toDoPoint.getId().equals(taskId));
        userRepository.save(user);
    }

    @CrossOrigin
    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return userRepository.findById(userId)
                .map(point -> {
                    point.setFirstName(user.getFirstName());
                    point.setLastName(user.getLastName());
                    point.setToDoPoints(user.getToDoPoints());
                    point.setEmail(user.getEmail());
                    return userRepository.save(point);
                })
                .orElseGet(() -> {
                    user.setId(userId);
                    return userRepository.save(user);
                });
    }

    @CrossOrigin
    @PutMapping("/users/{userId}/{taskId}")
    public ToDoPoint updateTask(@PathVariable Integer userId, @PathVariable Integer taskId, @RequestBody ToDoPoint toDoPoint) {
        User user = userRepository.findById(userId).orElseThrow();
        for (ToDoPoint updatedPoint : user.getToDoPoints()) {
            if (updatedPoint.getId().equals(taskId)) {
                updatedPoint.setTitle(toDoPoint.getTitle());
                updatedPoint.setDescription(toDoPoint.getDescription());
                updatedPoint.setDone(toDoPoint.isDone());
                updatedPoint.setDueDate(toDoPoint.getDueDate());
            }
        }
        return toDoPoint;
    }
}