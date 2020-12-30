package com.ToDoListBySpringJava.models;

import java.util.Date;

public interface DashboardListDTO {

    Integer getUndoneToDoPoints();
    String getName();
    String getDescription();
    Date getDue_date();
    Integer getId_task();
}
