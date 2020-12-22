package com.ToDoListBySpringJava.repository;


import com.ToDoListBySpringJava.models.ToDoPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoTableRepository extends JpaRepository<ToDoPoint, Object> {
}
