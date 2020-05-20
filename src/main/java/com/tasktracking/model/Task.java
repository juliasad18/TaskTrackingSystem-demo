package com.tasktracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "tms_tasks", schema = "tasktracking")
public class Task {

    @Id
    @GeneratedValue
    //@Column(name = "tms_task_id")
    private int tmsTaskId;

    @Column(name = "task_group")
    private String taskGroup;

    @Column(name = "task_summary")
    private String taskSummary;

    @Column(name = "is_finished", columnDefinition = "false")
    private String isFinishedFlag;

    @Column(name = "logged_time")
    private int loggedTime;

    @Column(name = "task_assignee")
    private String taskAssignee;

    public Task() {
    }


    public Task(int tmsTaskId, String taskGroup, String taskSummary, String isFinishedFlag, int loggedTime, String taskAssignee) {
        this.tmsTaskId = tmsTaskId;
        this.taskGroup = taskGroup;
        this.taskSummary = taskSummary;
        this.isFinishedFlag = isFinishedFlag;
        this.loggedTime = loggedTime;
        this.taskAssignee = taskAssignee;
    }

    public int getTmsTaskId() {
        return tmsTaskId;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public String getTaskSummary() {
        return taskSummary;
    }

    public String getIsFinishedFlag() {
        return isFinishedFlag;
    }

    public int getLoggedTime() {
        return loggedTime;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTmsTaskId(int tmsTaskId) {
        this.tmsTaskId = tmsTaskId;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    public void setIsFinishedFlag(String isFinishedFlag) {
        this.isFinishedFlag = isFinishedFlag;
    }

    public void setLoggedTime(int loggedTime) {
        this.loggedTime = loggedTime;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }
}
