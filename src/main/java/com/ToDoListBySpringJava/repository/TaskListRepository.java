package com.ToDoListBySpringJava.repository;

import com.ToDoListBySpringJava.models.DashboardListDTO;
import com.ToDoListBySpringJava.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

    @Query(nativeQuery = true, value = "SELECT COUNT(id_task) FROM task_list WHERE due_date = :date")
    public Integer searchDashboard(@Param("date") LocalDate dueDate);

    @Query(nativeQuery = true, value = "SELECT task_list.name, task_list.description, task_list.due_date, task_list.id_task, COUNT(todo_points.id) AS UndoneToDoPoints FROM todo_points RIGHT JOIN task_list ON todo_points.id_task = task_list.id_task WHERE todo_points.done = 'false' GROUP BY task_list.id_task;")
    public List<DashboardListDTO> searchUnDoneTasks();
}
