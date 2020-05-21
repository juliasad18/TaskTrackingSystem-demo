package com.tasktracking.controller;

import com.tasktracking.model.Task;
import com.tasktracking.services.TasksService;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TasksService tasksService;

    @Test
    public void testGetAllTasks() throws Exception{
        Task taskForTest1 = new Task(11, "TEST", "Test 1st row", false, 10, "Tester");
        Task taskForTest2 = new Task(12, "TEST", "Test 2nd row", false, 10, "Tester");
        Task taskForTest3 = new Task(13, "TEST", "Test 3rd row", false, 10, "Tester");
        List<Task> tasksList = Arrays.asList(taskForTest1, taskForTest2, taskForTest3);

        given(tasksService.findTasks()).willReturn(tasksList);

        mvc.perform( get("/getTask") ).andExpect( status().isOk() ).andExpect( content().json("[{\"tmsTaskId\":11,\"taskGroup\":\"TMS\",\"taskSummary\":\"Test 1st row\",\"isFinishedFlag\":false,\"loggedTime\":10,\"taskAssignee\":\"Tester\"},{\"tmsTaskId\":12,\"taskGroup\":\"TMS\",\"taskSummary\":\"Test 2nd row\",\"isFinishedFlag\":false,\"loggedTime\":10,\"taskAssignee\":\"Tester\"},{\"tmsTaskId\":13,\"taskGroup\":\"TMS\",\"taskSummary\":\"Test 3rd row\",\"isFinishedFlag\":false,\"loggedTime\":10,\"taskAssignee\":\"Tester\"}]") );



    }


}
