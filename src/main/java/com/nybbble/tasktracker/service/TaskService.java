package com.nybbble.tasktracker.service;

import com.nybbble.tasktracker.dto.TaskCreateRequest;
import com.nybbble.tasktracker.dto.TaskResponse;
import com.nybbble.tasktracker.dto.TaskUpdateRequest;
import com.nybbble.tasktracker.exception.TaskNotFoundException;
import com.nybbble.tasktracker.model.Task;
import com.nybbble.tasktracker.model.TaskStatus;
import com.nybbble.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getAllTasks(TaskStatus status) {
        List<Task> tasks;

        if (status == null) {
            tasks = taskRepository.findAll();
        } else {
            tasks = taskRepository.findByStatus(status);
        }

        return tasks.stream()
                .map(this::toResponse)
                .toList();
    }

    public TaskResponse getTaskById(Long id) {
        Task task = findTaskById(id);
        return toResponse(task);
    }

    public TaskResponse createTask(TaskCreateRequest request) {
        Task task = new Task(
                request.title(),
                request.description(),
                TaskStatus.TODO
        );

        Task savedTask = taskRepository.save(task);

        return toResponse(savedTask);
    }

    public TaskResponse updateTask(Long id, TaskUpdateRequest request) {
        Task task = findTaskById(id);

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());

        Task updatedTask = taskRepository.save(task);

        return toResponse(updatedTask);
    }

    public TaskResponse markTaskAsDone(Long id) {
        Task task = findTaskById(id);

        task.setStatus(TaskStatus.DONE);

        Task updatedTask = taskRepository.save(task);

        return toResponse(updatedTask);
    }

    public void deleteTask(Long id) {
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }

    private Task findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
