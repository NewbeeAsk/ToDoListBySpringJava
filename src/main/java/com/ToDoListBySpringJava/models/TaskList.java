package com.ToDoListBySpringJava.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "taskList")
public class TaskList  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_task")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname cannot be empty")
    @Column(name = "description")
    private String description;

    @Future(message = "Must be a future date")
    @Column(name = "dueDate")
    private LocalDate dueDate;

    public TaskList() {
    }

    public TaskList(String name, String description, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
