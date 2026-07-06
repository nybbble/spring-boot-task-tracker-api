# TaskManagementSystem

### Repo:


task-management-system/
├── pom.xml
├── README.md
├── docker-compose.yml
├── .gitignore
├── src/
│   ├── main/
│   │   ├── java/com/nybbble/taskmanagement/
│   │   │   ├── TaskManagementApplication.java
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   │   ├── service/
│   │   │   │   └── TaskService.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   ├── model/
│   │   │   │   ├── Task.java
│   │   │   │   └── TaskStatus.java
│   │   │   ├── dto/
│   │   │   │   ├── TaskCreateRequest.java
│   │   │   │   ├── TaskUpdateRequest.java
│   │   │   │   └── TaskResponse.java
│   │   │   └── exception/
│   │   │       ├── TaskNotFoundException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/com/nybbble/taskmanagement/
│           ├── TaskServiceTest.java
│           └── TaskControllerTest.java

A simple **RESTful API** built with **Java Spring Boot + PostgreSQL** for managing tasks.

**🚀 Features**
- Create a new task
- Get all tasks
- Delete task by ID
- PostgreSQL database integration
- Dockerized for easy deployment

**🛠️ Tech Stack**
- Java 17
- Spring Boot 3
- PostgreSQL
- Docker

## ▶️ How to Run
### 1️⃣ Run PostgreSQL with Docker
```bash
docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=tasksdb -p 5432:5432 -d postgres
```
**📌 Build and Run Application**
```bash
mvn clean package -DskipTests
docker build -t task-management .
docker run -p 8080:8080 --name task-app --link postgres task-management
```

**📌 API Endpoints**
```bash
GET /api/tasks → List all tasks
POST /api/tasks → Create new task
DELETE /api/tasks/{id} → Delete task
```
**📌 Example Request**
```bash
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Finish project","description":"Complete GitHub plan","completed":false}'
```
