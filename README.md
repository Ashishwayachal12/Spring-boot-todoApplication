# 📝 ToDo List Web Application

A simple, elegant ToDo List web application built with **Spring Boot**, **Thymeleaf**, and **Bootstrap 5**. Users can add, delete, and mark tasks as completed in a clean and responsive UI.

---

## 🚀 Features

- Add new tasks
- Delete existing tasks
- Toggle completion status (mark as done/undone)
- Responsive and clean UI using Bootstrap and custom CSS
- Uses Thymeleaf for server-side rendering
- Persistent storage with Spring Data JPA and H2/MySQL (configurable)

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring MVC, Spring Data JPA
- **Frontend:** Thymeleaf, HTML, CSS, Bootstrap 5
- **Database:** H2 (in-memory) or MySQL
- **Build Tool:** Maven
- **Java Version:** 17+

---

## 📁 Project Structure

src/
└── main/
├── java/
│ └── in.ashishwayachal.todo_list/
│ ├── controller/
│ │ └── TodoController.java
│ ├── entity/
│ │ └── Todo.java
│ ├── repository/
│ │ └── todoRepository.java
│ └── TodoListApplication.java
└── resources/
├── templates/
│ └── index.html
├── static/
│ └── css/
│ └── style.css
└── application.properties



---

## ⚙️ Configuration

### `application.properties` (for H2 or MySQL)

```properties
# H2 (default)
spring.datasource.url=jdbc:h2:mem:todo_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
