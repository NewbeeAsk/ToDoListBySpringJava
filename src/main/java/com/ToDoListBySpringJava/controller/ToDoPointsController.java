package com.ToDoListBySpringJava.controller;


import com.ToDoListBySpringJava.models.ToDoPoint;
import com.ToDoListBySpringJava.repository.ToDoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class ToDoPointsController {

    @Autowired
    private ToDoTableRepository toDoTableRepository;

    public ToDoPointsController(ToDoTableRepository toDoTableRepository) {
        this.toDoTableRepository = toDoTableRepository;
    }


    @CrossOrigin
    @GetMapping
    public List<ToDoPoint> getToDoPoints() {
        return toDoTableRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("{id}")
    public Optional<ToDoPoint> toDoPointById(@PathVariable Integer id) {
        return toDoTableRepository.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public ToDoPoint create(@RequestBody ToDoPoint toDoPoint) {
        return toDoTableRepository.save(toDoPoint);
    }

    @CrossOrigin
    @PutMapping("{id}")
    public ToDoPoint update(@PathVariable Integer id, @RequestBody ToDoPoint toDoPoint) {
        return toDoTableRepository.findById(id)
                .map(point -> {
                    point.setTitle(toDoPoint.getTitle());
                    point.setDescription(toDoPoint.getDescription());
                    point.setDone(toDoPoint.getDone());
                    point.setDueDate(toDoPoint.getDueDate());
                    return toDoTableRepository.save(point);
                })
                .orElseGet(() -> {
                    toDoPoint.setId(id);
                    return toDoTableRepository.save(toDoPoint);
                });
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        toDoTableRepository.deleteById(id);
    }
}