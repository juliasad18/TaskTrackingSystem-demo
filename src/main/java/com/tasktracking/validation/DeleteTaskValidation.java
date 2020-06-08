package com.tasktracking.validation;

import com.tasktracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskValidation {

    @Autowired
    public TaskCompletionValidation taskCompletionValidation;

    public int[] getSubTasksToDelete(int taskId) {
        boolean a = taskCompletionValidation.doesTaskHaveSubTask(taskId);
        if (taskCompletionValidation.doesTaskHaveSubTask(taskId)) {
            int[] list = taskCompletionValidation.getSubTaskIds(taskId);
            return taskCompletionValidation.getSubTaskIds(taskId);
        } else {
            return new int[0];
        }
    }


}
