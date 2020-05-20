package com.tasktracking.services;

import com.tasktracking.model.Task;
import com.tasktracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insertNewTask(Task task) {
        int tmsTaskId = task.getTmsTaskId();
        String taskGroup = task.getTaskGroup();
        String taskSummary = task.getTaskSummary();
        Boolean isFinishedFlag = task.getIsFinishedFlag();
        int logTime = task.getLoggedTime();
        String taskAssignee = task.getTaskAssignee();
        taskRepository.insertNewTask(tmsTaskId, taskGroup, taskSummary, isFinishedFlag, logTime, taskAssignee);
    }

    public void removeTaskById(int taskId) {
        taskRepository.removeTaskById(taskId);
    }

    public void updateLoggedTime(int taskId, Task task) {
        int logTime = task.getLoggedTime();
        taskRepository.updateLoggedTime(logTime, taskId);
    }










}

