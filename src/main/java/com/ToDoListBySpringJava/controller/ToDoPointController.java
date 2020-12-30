package com.ToDoListBySpringJava.controller;

import com.ToDoListBySpringJava.models.ToDoPoint;
import com.ToDoListBySpringJava.repository.TaskListRepository;
import com.ToDoListBySpringJava.repository.ToDoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists/{listId}/tasks")
public class ToDoPointController {

    @Autowired
    private final TaskListRepository taskListRepository;

    @Autowired
    private final ToDoTableRepository toDoTableRepository;

    public ToDoPointController(TaskListRepository taskListRepository, ToDoTableRepository toDoTableRepository) {
        this.taskListRepository = taskListRepository;
        this.toDoTableRepository = toDoTableRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<ToDoPoint> getTasksBuListId(@PathVariable Integer listId, @RequestParam(defaultValue = "false") boolean all) {
        if (all) {
            return toDoTableRepository.findAll();
        } else {
            return toDoTableRepository.searchOpenToDoPoints(false);
        }
    }
}