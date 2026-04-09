# Worker Spring API

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)

A RESTful API built with Spring Boot for managing workers, departments, and hourly contracts. The application calculates worker income based on their base salary and additional contracts for a specific month and year.

## 🚀 Features

- **Worker Management**: Manage worker details including name, level (Junior, Mid-Level, Senior), and base salary.
- **Department Management**: Organize workers into different departments (e.g., Design, Back-End, Front-End).
- **Contract Management**: Track hourly contracts for each worker.
- **Income Calculation**: Calculate total income for a worker in a given month/year, summing the base salary and all contract values for that period.
- **Data Seeding**: Automatic database seeding with sample data on startup for easy testing.

## 🛠️ Technologies Used

- **Java 25**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **H2 Database** (In-memory for development)
- **PostgreSQL** (Driver included for production)
- **Maven** (Dependency management)

## 📂 Project Structure

```text
src/main/java/com/portifolio/gustavo/worker_spring_api/
├── config/             # Configuration classes (e.g., Database Seeding)
├── controller/         # REST Controllers
├── dto/                # Data Transfer Objects
├── entities/           # JPA Entities (Worker, Department, HourContract)
│   └── enums/          # Enumerations (WorkerLevel)
├── repositories/       # Spring Data JPA Repositories
└── WorkerSpringApiApplication.java # Main Application Class
```

## 🚦 Getting Started

### Prerequisites

- Java 25 or higher
- Maven 3.9+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/worker-spring-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd worker-spring-api
   ```

### Running the Application

Using Maven:
```bash
./mvnw spring-boot:run
```

The server will start at `http://localhost:8080`.

## 🛣️ API Endpoints

### Workers

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/workers/{id}/income/{year}/{month}` | Returns the total income of a worker for a specific month/year. |

**Example Request:**
`GET http://localhost:8080/workers/1/income/2025/8`

**Example Response:**
```json
{
  "name": "Alpha",
  "departmentName": "Design",
  "income": 6900.0
}
```

## 🗄️ Database Configuration

By default, the project uses an **H2 In-Memory Database** for development.

- **Console URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(empty)*

The project is also prepared for **PostgreSQL** in production environments.

---
Developed by [Gustavo Santos](https://github.com/gustavo-santos)
