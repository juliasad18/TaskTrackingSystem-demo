package com.tasktracking.services;

import com.tasktracking.model.Task;
import com.tasktracking.repository.TaskRepository;
import com.tasktracking.validation.TaskCompletionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public TaskCompletionValidation taskCompletionValidation;


    public List<Task> findTasks() {
        return (List<Task>) taskRepository.findAll();

    }

    public Task findTaskById(int taskId) {
        return taskRepository.findTaskById(taskId);

    }

    public void insertNewTask(Task task) {
        int tmsTaskId = task.getTmsTaskId();
        String taskGroup = task.getTaskGroup();
        String taskSummary = task.getTaskSummary();
        boolean isFinishedFlag = task.getIsFinishedFlag();
        int logTime = task.getLoggedTime();
        String taskAssignee = task.getTaskAssignee();
        Integer parentTaskId = task.getParentTaskId();
        taskRepository.insertNewTask(tmsTaskId, taskGroup, taskSummary, isFinishedFlag, logTime, taskAssignee, parentTaskId);
    }

    public void removeTaskById(int taskId) {
        taskRepository.removeTaskById(taskId);
    }

    public void updateLoggedTime(int taskId, Task task) {
        int logTime = task.getLoggedTime();
        taskRepository.updateLoggedTime(logTime, taskId);
    }

    public void updateTaskStatus(int taskId, Task task) {
        if (taskCompletionValidation.isSetTaskCompletedAllowed(taskId)) {
            Boolean isFinishedFlag = task.getIsFinishedFlag();
            taskRepository.updateTaskStatus(isFinishedFlag, taskId);
        }
    }


}

