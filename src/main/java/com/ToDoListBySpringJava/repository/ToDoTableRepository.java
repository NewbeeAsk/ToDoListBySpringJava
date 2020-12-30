package com.ToDoListBySpringJava.repository;


import com.ToDoListBySpringJava.models.ToDoPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ToDoTableRepository extends JpaRepository<ToDoPoint, Object> {

    @Query(nativeQuery = true, value = "SELECT * FROM todo_points WHERE due_date = :date")
    public List<ToDoPoint> searchTodayToDoPoints(@Param("date") LocalDate dueDate);

    @Query(nativeQuery = true, value = "SELECT * FROM todo_points WHERE done = :all")
    public List<ToDoPoint> searchOpenToDoPoints(@Param("all") Boolean all);
}
