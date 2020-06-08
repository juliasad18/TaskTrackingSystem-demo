package com.tasktracking.controller;

import com.tasktracking.Application;
import com.tasktracking.services.TasksService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ Application.class })
@AutoConfigureMockMvc
public class TaskTrackingIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TasksService tasksService;

    @Autowired
    private TaskController taskController;

    @Before
    public void setup() throws Exception {
        this.mvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }



}
