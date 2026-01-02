
## 📘 Online Book Store Management System

An Online Book Store Management System built with Java and Spring Boot, exposing RESTful APIs for managing book inventory.
The application integrates with MySQL using Spring Data JPA and follows a clean layered architecture (Controller, Service, Repository).

---

## 🚀 Features

### 📚 Book Management

* Add new books
* View all books
* View book by ID
* Update book details
* Delete book
* Search books by title (case-insensitive)

### 🔍 Search & Filter

* Search books using title keyword
* REST-based filtering

### 🧪 Testing

* APIs tested using **Postman**
* Database verified using **MySQL**

---

## 🛠 Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Web (REST APIs)
* Hibernate

### Database

* MySQL

### Tools

* Maven
* Git & GitHub
* Postman
* STS / IntelliJ / Eclipse

---

## 📂 Project Structure

```
Online-Book-Store-Management-System
│
├── src/main/java
│   └── com.mayur.bookstore
│       ├── controller
│       │   └── BookController.java
│       ├── service
│       │   ├── BookService.java
│       │   └── BookServiceImpl.java
│       ├── repository
│       │   └── BookRepository.java
│       ├── model
│       │   └── Book.java
│       └── OnlineBookStoreManagementSystemApplication.java
│
├── src/main/resources
│   ├── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

---

## ⚙️ Setup & Run Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/Online-Book-Store-Management-System.git
cd Online-Book-Store-Management-System
```

### 2️⃣ Configure MySQL Database

Create database in MySQL:

```sql
CREATE DATABASE bookstore_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

OR
Run `OnlineBookStoreManagementSystemApplication.java` from IDE.

---

## 🔗 REST API Endpoints

### ➕ Add Book

```
POST /api/books
```

### 📖 Get All Books

```
GET /api/books
```

### 🔍 Get Book By ID

```
GET /api/books/{id}
```

### ✏️ Update Book

```
PUT /api/books/{id}
```

### ❌ Delete Book

```
DELETE /api/books/{id}
```

### 🔎 Search Book By Title

```
GET /api/books/search?title=java
```

---

## 🧪 API Testing

* Tested using **Postman**
* All CRUD operations verified
* MySQL data checked using:

```sql
SELECT * FROM book;
```

---


---

## 👨‍💻 Author

**Mayur Kumbhare**
* GitHub: https://github.com/mayur199
* Email: kumbharemayur75@gmail.com
* Location: Pune, India


