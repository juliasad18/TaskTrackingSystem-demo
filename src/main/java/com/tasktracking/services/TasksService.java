package com.tasktracking.services;

import com.tasktracking.model.Task;
import com.tasktracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TasksService {

    @Autowired
    public TaskRepository taskRepository;


    public List<Task> findTasks() {
        return (List<Task>) taskRepository.findAll();

    }

    public List<Task> findTaskById(int taskId) {
        return (List<Task>) taskRepository.findTaskById(taskId);

    }

//    public void insertNewTask(List<Task> newTask) {
//        newTask.forEach(task -> taskRepository.insertNewTask(task.getTaskGroup(), task.getTaskSummary(), task.getLoggedTime(), task.getTaskAssignee()));
//        //taskGroup, taskSummary, loggedTime, taskAssignee
//    }

    public void insertNewTask(Task task) {
        String taskGroup = task.getTaskGroup();
        String taskSummary = task.getTaskSummary();
        Boolean isFinishedFlag = task.getIsFinishedFlag();
        int logTime = task.getLoggedTime();
        String taskAssignee = task.getTaskAssignee();
        taskRepository.insertNewTask(taskGroup, taskSummary, isFinishedFlag, logTime, taskAssignee);
    }

    public void removeTaskById(int taskId) {
        taskRepository.removeTaskById(taskId);
    }

    public void updateLoggedTime(int taskId, Task task) {
        int logTime = task.getLoggedTime();
        taskRepository.updateLoggedTime(logTime, taskId);
    }










}

