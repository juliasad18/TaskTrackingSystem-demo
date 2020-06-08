package com.tasktracking.validation;

import com.tasktracking.model.Task;
import com.tasktracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCompletionValidation {

    @Autowired
    public TaskRepository taskRepository;

    public boolean isTaskAParentTask(int taskId) {
        Task task = taskRepository.findTaskById(taskId);
        Integer parentTaskId = task.getParentTaskId();
        if(parentTaskId == null){
            return true;
        } else {
            return false;
        }
    }

    public boolean doesTaskHaveSubTask(int taskId){
        List<Task> subTaskList = taskRepository.findSubTasks(taskId);
        if (subTaskList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int[] getSubTaskIds(int taskId) {
        List<Task> subTaskList = taskRepository.findSubTasks(taskId);
        int[] subTaskArray = new int [subTaskList.size()];
        int counter = 0;
        for(Task task : subTaskList) {
            subTaskArray[counter] = task.getTmsTaskId();
            counter++;
        }
        return subTaskArray;
    }

    public boolean areTasksCompleted(int[] subTaskArray) {
        boolean areTasksCompleted = false;
        for (int subTaskId : subTaskArray) {
            if(!taskRepository.findTaskById(subTaskId).getIsFinishedFlag()) {
                areTasksCompleted = false;
            } else {
                areTasksCompleted = true;
            }
        }
        return areTasksCompleted;

    }

    public boolean isSetTaskCompletedAllowed(int taskId) {
        if (isTaskAParentTask(taskId)) {
            if (doesTaskHaveSubTask(taskId)) {
                if(areTasksCompleted(getSubTaskIds(taskId))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }




}
