package com.ToDoListBySpringJava.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "todo_points")
public class ToDoPoint  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be empty")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    @Future(message = "Must be a future date")
    @Column(name = "dueDate")
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_task")
    private TaskList taskList;

    public ToDoPoint(){}

    public ToDoPoint(String title, String description, boolean done, LocalDate dueDate, TaskList taskList) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
        this.taskList = taskList;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
