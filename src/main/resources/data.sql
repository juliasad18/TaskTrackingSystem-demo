CREATE SCHEMA [ IF NOT EXISTS ] tasktracking AUTHORIZATION sa;

DROP TABLE IF EXISTS tms_tasks;
CREATE TABLE tms_tasks (
  task_group VARCHAR(100) NOT NULL,
  tms_task_id INT(11) NOT NULL,
  task_summary VARCHAR(100) NOT NULL,
  is_finished BIT NOT NULL,
  logged_time INT(11) NOT NULL,
  task_assignee VARCHAR(100) NOT NULL,
  PRIMARY KEY (tms_task_id)
);

DROP TABLE IF EXISTS tms_tasks_relation;
CREATE TABLE tms_tasks_relation (
  parent_task_id INT(11) NOT NULL,
  related_task_id INT(11) NOT NULL,
  board VARCHAR(100) NOT NULL,
  UNIQUE KEY AK_related_task_id (related_task_id)
);

INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 1, "Create GetMapping method", 0, 10, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 2, "Development", 1, 10, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 3, "System Testying", 0, 0, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 4, "Create DeleteMapping method", 0, 2, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 5, "Development", 1, 2, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 6, "System Testying", 0, 0, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 7, "Create PutMapping method", 0, 5, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 8, "Development", 0, 5, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 9, "System Testying", 0, 0, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 10, "Create PostMapping method", 0, 5, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 11, "Development", 0, 5, "juliasad");
INSERT INTO tms_tasks (task_group, tms_task_id, task_summary, is_finished, logged_time, task_assignee) VALUES ("TMS", 12, "System Testying", 0, 0, "juliasad");

INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (1, 2, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (1, 3, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (4, 5, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (4, 6, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (7, 8, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (7, 9, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (10, 11, "TMS");
INSERT INTO tms_tasks_relation (parent_task_id, related_task_id, board) VALUES (10, 12, "TMS");