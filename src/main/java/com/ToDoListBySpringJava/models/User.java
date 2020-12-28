package com.ToDoListBySpringJava.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String firstName;

    @NotEmpty(message = "Surname cannot be empty")
    @Column(name = "surname")
    private String lastName;

    @NotEmpty(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "user_tdpoints", referencedColumnName = "id")
    private List<ToDoPoint> toDoPoints = new ArrayList<>();

    public User(){}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ToDoPoint> getToDoPoints() {
        return toDoPoints;
    }

    public void setToDoPoints(List<ToDoPoint> toDoPoints) {
        this.toDoPoints = toDoPoints;
    }
}
