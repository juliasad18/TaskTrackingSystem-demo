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
    Task findTaskById(@Param("id") int taskId);

    @Query(value = "SELECT t FROM Task t WHERE t.parentTaskId = :id")
    List<Task> findSubTasks(@Param("id") int taskId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tms_tasks (tms_task_id, task_group, task_summary, is_finished, logged_time, task_assignee, parent_task_id) " +
            "VALUES (:taskId, :group, :summary, :isFinished, :loggedTime, :assignee, :parentTaskId)", nativeQuery = true)
    void insertNewTask(@Param("taskId") int taskId, @Param("group") String taskGroup, @Param("summary") String taskSummary, @Param("isFinished") Boolean isFinishedFlag, @Param("loggedTime") int loggedTime,
                        @Param("assignee") String taskAssignee, @Param("parentTaskId") Integer parentTaskId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Task t WHERE t.tmsTaskId = :id")
    void removeTaskById(@Param("id") int taskId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Task t SET t.loggedTime = :loggedTime WHERE t.tmsTaskId = :id")
    void updateLoggedTime(@Param("loggedTime") int loggedTime, @Param("id") int taskId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Task t SET t.isFinishedFlag = :isFinished WHERE t.tmsTaskId = :id")
    void updateTaskStatus(@Param("isFinished") Boolean isFinishedFlag, @Param("id") int taskId);


}
