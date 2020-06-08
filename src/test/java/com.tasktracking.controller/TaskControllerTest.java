package com.tasktracking.controller;

import com.tasktracking.model.Task;
import com.tasktracking.services.TasksService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @Mock
    TasksService tasksServiceMock;

    @InjectMocks
    TaskController taskController;

    @Test
    public void getAllTasksTest() {

        Task taskForTest1 = new Task(11, "TEST", "Test 1st row", false, 10, "Tester", null);
        Task taskForTest2 = new Task(12, "TEST", "Test 2nd row", false, 10, "Tester", null);
        Task taskForTest3 = new Task(13, "TEST", "Test 3rd row", false, 10, "Tester", null);
        List<Task> tasksList = Arrays.asList(taskForTest1, taskForTest2, taskForTest3);

        when(tasksServiceMock.findTasks()).thenReturn(tasksList); //insert dummy list into TasksService -> findTasks(), not from the DB

        assertEquals(3, taskController.getAllTasks().size());

    }

    @Test
    public void getTaskByIdTest() {
        Task task = new Task();
        task.setTmsTaskId(11);
        task.setTaskGroup("TEST");
        task.setTaskSummary("Test getTaskByIdTest() method");
        task.setIsFinishedFlag(false);
        task.setLoggedTime(10);
        task.setTaskAssignee("Tester");
        //task.getParentTaskId(null);

        when(tasksServiceMock.findTaskById(11)).thenReturn(task);

        assertEquals(11, taskController.getTaskById(11).getTmsTaskId());
        assertEquals("TEST", taskController.getTaskById(11).getTaskGroup());
        assertEquals("Test getTaskByIdTest() method", taskController.getTaskById(11).getTaskSummary());
        assertEquals(false, taskController.getTaskById(11).getIsFinishedFlag());
        assertEquals(10, taskController.getTaskById(11).getLoggedTime());
        assertEquals("Tester", taskController.getTaskById(11).getTaskAssignee());
        assertEquals(null, taskController.getTaskById(11).getParentTaskId());


    }




}
