package com.tasktracking.controller;

import com.tasktracking.model.Task;
import com.tasktracking.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TasksService tasksService;

    @GetMapping("/getTask")
    public List<Task> getAllTasks() {
        return tasksService.findTasks();
    }

    @GetMapping("/getTask/{taskId}")
    public Task getTaskById(@PathVariable("taskId") int taskId) {
        return tasksService.findTaskById(taskId);
    }

    @PostMapping("/addNewTask")
    public void createTask(@RequestBody Task newTask) {
        tasksService.insertNewTask(newTask);
    }

    @DeleteMapping("/getTask/{taskId}")
    public void removeTask(@PathVariable("taskId") int taskId) {
        tasksService.removeTaskById(taskId);
    }

    @PutMapping("/logTime/{taskId}")
    public void updateLoggedTime(@PathVariable("taskId") int taskId, @RequestBody Task task){
        tasksService.updateLoggedTime(taskId,  task);
    }

    @PutMapping("/updateTaskStatus/{taskId}")
    public void updateTaskStatus(@PathVariable("taskId") int taskId, @RequestBody Task task){
        tasksService.updateTaskStatus(taskId,  task);
    }


}
