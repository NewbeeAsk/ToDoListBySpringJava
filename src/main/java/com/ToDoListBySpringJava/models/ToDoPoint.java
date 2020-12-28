package com.ToDoListBySpringJava.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "todopoints")
public class ToDoPoint {

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

    public ToDoPoint(){}

    public ToDoPoint(String title, String description, boolean done, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
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
