
# Todo Web Application

## Project Overview

This repository contains a Todo Web Application built using Spring Boot and Thymeleaf. The application is designed to manage tasks efficiently, providing a clean interface and full CRUD functionality. This project showcases my understanding of backend development with Spring Boot and my ability to create interactive and user-friendly web applications.

## Key Features

- Full CRUD operations for managing tasks.
- Interactive UI built with Thymeleaf and HTML/CSS.
- In-memory H2 database for task storage and management.

## Technologies Used

- **Java**
- **Spring Boot**
- **Thymeleaf**
- **H2 Database**

## Project Structure and Code Explanation

1. **Task Entity**:
   - Represents a task in the application, including fields like `id`, `description`, and `status`.
   ```java
   @Entity
   public class Task {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String description;
       private boolean isComplete;
       // Getters and setters
   }
   ```

2. **Service Layer**:
   - Contains business logic for task management, such as adding, updating, and deleting tasks.
   ```java
   @Service
   public class TaskService {
       // Logic for managing tasks
   }
   ```

3. **Controller Layer**:
   - Manages RESTful endpoints and handles the rendering of Thymeleaf templates.
   ```java
   @Controller
   @RequestMapping("/tasks")
   public class TaskController {
       // Mapping endpoints for task management
   }
   ```

4. **UI and Template Engine**:
   - The application uses Thymeleaf for dynamic rendering, providing an intuitive user interface for managing tasks.

5. **Database Configuration**:
   - The H2 in-memory database is used to store tasks, which can be easily switched to a persistent database if needed.

## Project Output

Here are some screenshots showing the key features and output of the application:

1. **Application Configuration in IDE**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-1.png" alt="Application Properties" style="height: 50%;">

2. **Todo List UI**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-2.png" alt="Todo List" style="height: 50%;">

3. **Edit Todo Item UI**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-3.png" alt="Edit Todo Item" style="height: 50%;">

4. **Add Todo Item UI**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-4.png" alt="Add Todo Item" style="height: 50%;">

5. **Updated Todo List UI**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-5.png" alt="Updated Todo List" style="height: 50%;">

6. **H2 Database Console**:
   <img src="https://github.com/MalingaBandara/Todo-Web-Application/blob/main/p2/proj-6.png" alt="H2 Database Console" style="height: 50%;">


## Commits and Project Evolution

1. **Initial Setup**: Created project structure and added basic task entity.
2. **CRUD Operations**: Implemented task management features.
3. **UI Development**: Added Thymeleaf templates for task list, creation, and updates.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/Todo-Web-Application.git
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Run the service:
   ```bash
   mvn spring-boot:run
   ```

## Purpose and Future Enhancements

This project demonstrates the development of a simple yet fully functional web application using Spring Boot. Future enhancements may include user authentication, task categorization, and notifications.

## License

This project is licensed under the MIT License.
