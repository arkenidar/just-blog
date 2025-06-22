# MySQL Setup Instructions

## Environment Configuration

This project uses a `.env` file for environment variables. 

1. **Copy the example environment file:**
   ```bash
   cp .env.example .env
   ```

2. **Edit the `.env` file** with your database credentials:
   ```env
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=justblog
   DB_USERNAME=root
   DB_PASSWORD=your_secure_password
   ```

## Option 1: Using Docker (Recommended for Development)

1. **Install Docker Desktop** if you haven't already

2. **Configure your `.env` file** (see above)

3. **Start MySQL container:**
   ```bash
   docker-compose up -d
   ```

4. **Verify MySQL is running:**
   ```bash
   docker-compose ps
   ```

5. **Run the application:**
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

3. **Configure your `.env` file** with your MySQL credentials (see above)

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## Environment Variables Reference

| Variable | Description | Default |
|----------|-------------|---------|
| `DB_HOST` | Database host | localhost |
| `DB_PORT` | Database port | 3306 |
| `DB_NAME` | Database name | justblog |
| `DB_USERNAME` | Database username | root |
| `DB_PASSWORD` | Database password | yourpassword |
| `SERVER_PORT` | Application port | 8080 |
| `SPRING_PROFILES_ACTIVE` | Active Spring profile | prod |
| `JPA_SHOW_SQL` | Show SQL queries | true |
| `JPA_DDL_AUTO` | Hibernate DDL auto | update |

## Profile Selection

- **Development with H2:** `mvn spring-boot:run -Dspring.profiles.active=dev`
- **Production with MySQL:** `mvn spring-boot:run -Dspring.profiles.active=prod`

## Database Migration

When switching from H2 to MySQL, your data will be lost since H2 is in-memory. The application will automatically create the necessary tables in MySQL on first startup.
