# Spring Boot Task Tracker API

A simple task tracking REST API built with Java and Spring Boot.

This project was created to practice the basic structure of a backend application using a layered architecture: controller, service, repository, and model. The main goal is to understand how a Spring Boot API handles task creation, listing, and deletion while keeping the code organized.

## Project Status

This project is still a work in progress.

The current version includes the basic backend structure for managing personal tasks. I plan to improve it step by step by adding validation, better error handling, update operations, filtering, tests, and a cleaner project structure.

## Features

Current features:

* Create a new task
* List all tasks
* Delete a task by ID
* Store task data using a JPA repository
* Separate controller, service, repository, and model layers

Planned improvements:

* Get a single task by ID
* Update an existing task
* Mark a task as completed
* Add task status such as `TODO`, `IN_PROGRESS`, and `DONE`
* Add priority levels
* Add due dates
* Add request validation
* Add global exception handling
* Add unit and controller tests
* Add Docker Compose support
* Improve README with API examples and screenshots

## Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL / H2 database support planned
* Maven

## Project Structure

The project currently has a minimal structure:

```text
Spring-Boot-Task-Tracker-API/
├── Task.java
├── TaskController.java
├── TaskRepository.java
├── TaskService.java
└── README.md
```

Planned structure after cleanup:

```text
src/
├── main/
│   ├── java/
│   │   └── com/nybbble/tasktracker/
│   │       ├── TaskTrackerApplication.java
│   │       ├── controller/
│   │       │   └── TaskController.java
│   │       ├── service/
│   │       │   └── TaskService.java
│   │       ├── repository/
│   │       │   └── TaskRepository.java
│   │       ├── model/
│   │       │   └── Task.java
│   │       └── exception/
│   │           └── GlobalExceptionHandler.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
```

## API Endpoints

Current endpoints:

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/tasks` | Get all tasks |
| `GET` | `/api/tasks/{id}` | Get a task by ID |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update a task |
| `PATCH` | `/api/tasks/{id}/complete` | Mark a task as completed |
| `DELETE` | `/api/tasks/{id}` | Delete a task by ID |
| `GET` | `/api/tasks?status=TODO` | Filter tasks by status |

## Example Task Object

```json
{
  "id": 1,
  "title": "Study Spring Boot",
  "description": "Practice REST API structure",
  "status": "TODO",
  "createdAt": "2026-07-07T14:30:00",
  "updatedAt": "2026-07-07T14:30:00"
}
```

## Example Request

Create a new task:

```
{
  "title": "Study Spring Boot",
  "description": "Practice REST API structure with controller, service and repository layers"
}
```

## What I Learned

While building this project, I focused on:

* Creating REST endpoints with Spring Boot
* Separating business logic from controller logic
* Using Spring Data JPA repositories
* Structuring a small backend project
* Understanding how entities are saved and retrieved
* Planning future improvements for a more realistic backend API
