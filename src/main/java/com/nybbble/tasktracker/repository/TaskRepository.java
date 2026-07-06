package com.nybbble.tasktracker.repository;

import com.nybbble.tasktracker.model.Task;
import com.nybbble.tasktracker.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
}
