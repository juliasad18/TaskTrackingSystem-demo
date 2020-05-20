package com.tasktracking.repository;

import com.tasktracking.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>  {

    @Query(value = "SELECT t FROM Task t WHERE t.tmsTaskId = :id")
    List<Task> findTaskById(@Param("id") int taskId);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO tms_tasks (task_group, task_summary, is_finished, logged_time, task_assignee) VALUES (:group, :summary, :loggedTime, :assignee)", nativeQuery = true)
//    void insertNewTask(@Param("group") String taskGroup, @Param("summary") String taskSummary, @Param("loggedTime") int loggedTime,
//                       @Param("assignee") String taskAssignee);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tms_tasks (task_group, task_summary, is_finished, logged_time, task_assignee) " +
            "VALUES (:group, :summary, :isFinished, :loggedTime, :assignee)", nativeQuery = true)
    void insertNewTask(@Param("group") String taskGroup, @Param("summary") String taskSummary, @Param("isFinished") Boolean isFinishedFlag, @Param("loggedTime") int loggedTime,
                        @Param("assignee") String taskAssignee);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Task t WHERE t.tmsTaskId = :id")
    void removeTaskById(@Param("id") int taskId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Task t SET t.loggedTime = :loggedTime WHERE t.tmsTaskId = :id")
    void updateLoggedTime(@Param("loggedTime") int loggedTime, @Param("id") int taskId);

//updateTask



}
