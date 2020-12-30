package com.ToDoListBySpringJava.Services;

import com.ToDoListBySpringJava.models.DashboardListDTO;

import java.util.List;

public class Dashboard {

    List<DashboardListDTO> dashboardListDTO;
    Integer TodayTaskList;

    public Dashboard(List<DashboardListDTO> dashboardListDTO, Integer todayTaskList) {
        this.dashboardListDTO = dashboardListDTO;
        TodayTaskList = todayTaskList;
    }

    public List<DashboardListDTO> getDashboardList() {
        return dashboardListDTO;
    }

    public void setDashboardList(List<DashboardListDTO> dashboardListDTO) {
        this.dashboardListDTO = dashboardListDTO;
    }

    public Integer getTodayTaskList() {
        return TodayTaskList;
    }

    public void setTodayTaskList(Integer todayTaskList) {
        TodayTaskList = todayTaskList;
    }
}
