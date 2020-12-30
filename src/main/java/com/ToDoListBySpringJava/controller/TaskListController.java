package com.ToDoListBySpringJava.controller;

import com.ToDoListBySpringJava.Services.Dashboard;
import com.ToDoListBySpringJava.exeption.NotFoundException;
import com.ToDoListBySpringJava.models.TaskList;
import com.ToDoListBySpringJava.models.ToDoPoint;
import com.ToDoListBySpringJava.repository.TaskListRepository;
import com.ToDoListBySpringJava.repository.ToDoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskListController {

    @Autowired
    private final TaskListRepository taskListRepository;

    @Autowired
    private final ToDoTableRepository toDoTableRepository;

    public TaskListController(TaskListRepository taskListRepository, ToDoTableRepository toDoTableRepository) {
        this.taskListRepository = taskListRepository;
        this.toDoTableRepository = toDoTableRepository;
    }

    @CrossOrigin
    @GetMapping("/dashboard")
    public Dashboard getDashboard() {
        return new Dashboard(taskListRepository.searchUnDoneTasks(), taskListRepository.searchDashboard(LocalDate.now()));
    }

    @CrossOrigin
    @GetMapping("/collection/today")
    public List<ToDoPoint> getTodayToDoPoints() {
        return toDoTableRepository.searchTodayToDoPoints(LocalDate.of(2020, 12, 30));
    }

    @CrossOrigin
    @GetMapping("/taskList")
    public List<TaskList> getTaskLists() {
        return taskListRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/taskList/{id}")
    public TaskList getTaskListById(@PathVariable Integer id) {
        return taskListRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @CrossOrigin
    @PostMapping("/taskList")
    public TaskList createTaskList(@RequestBody TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @CrossOrigin
    @PostMapping("/todoPoints/{id}")
    public ToDoPoint createToDoPoint(@PathVariable Integer id, @RequestBody ToDoPoint toDoPoint) {
        String title = toDoPoint.getTitle();
        String description = toDoPoint.getDescription();
        boolean done = toDoPoint.isDone();
        LocalDate dueDate = toDoPoint.getDueDate();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        toDoTableRepository.save(new ToDoPoint(title, description, done, dueDate, taskList));
        return toDoPoint;
    }
}