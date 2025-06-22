<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

# Just Blog - Spring Boot Application

This is a Spring Boot blog application with the following technologies:

## Tech Stack

- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Framework
- **Spring Data JPA** - Data access layer
- **Thymeleaf** - Template engine for web pages
- **H2 Database** - In-memory database for development
- **Bootstrap 5** - Frontend CSS framework
- **Maven** - Build tool

## Project Structure

- `src/main/java/com/example/justblog/` - Main application code
  - `model/` - Entity classes (BlogPost)
  - `repository/` - Data access layer
  - `service/` - Business logic layer
  - `controller/` - Web and REST controllers
  - `config/` - Configuration classes
- `src/main/resources/` - Resources
  - `templates/` - Thymeleaf templates
  - `application.properties` - Configuration
- `src/test/java/` - Test classes

## Features

- Create, read, update, delete blog posts
- Web interface with Thymeleaf templates
- REST API endpoints
- Responsive design with Bootstrap
- H2 console for database management
- Sample data initialization

## Development Notes

- Uses H2 in-memory database (data resets on restart)
- Hot reload enabled with Spring Boot DevTools
- H2 console available at `/h2-console`
- REST API endpoints available at `/api/posts`

## Coding Conventions

- Follow Spring Boot best practices
- Use proper MVC separation
- Repository pattern for data access
- Service layer for business logic
- RESTful API design
- Proper exception handling
