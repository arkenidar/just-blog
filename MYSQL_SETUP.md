# MySQL Setup Instructions

## Option 1: Using Docker (Recommended for Development)

1. **Install Docker Desktop** if you haven't already
2. **Start MySQL container:**
   ```bash
   docker-compose up -d
   ```
3. **Verify MySQL is running:**
   ```bash
   docker-compose ps
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## Option 2: Using Local MySQL Installation

1. **Install MySQL 8.0** from [MySQL Downloads](https://dev.mysql.com/downloads/mysql/)

2. **Create the database:**
   ```sql
   mysql -u root -p
   CREATE DATABASE justblog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. **Update application.properties** with your MySQL credentials:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## Environment Variables

You can use environment variables instead of hardcoding credentials:

```bash
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
mvn spring-boot:run
```

## Profile Selection

- **Development with H2:** `mvn spring-boot:run -Dspring.profiles.active=dev`
- **Production with MySQL:** `mvn spring-boot:run -Dspring.profiles.active=prod`

## Database Migration

When switching from H2 to MySQL, your data will be lost since H2 is in-memory. The application will automatically create the necessary tables in MySQL on first startup.
