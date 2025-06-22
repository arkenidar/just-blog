# Just Blog

A simple and elegant blog application built with Spring Boot, featuring a clean web interface and RESTful API.

## Features

- 📝 Create, read, update, and delete blog posts
- 🌐 Web interface with responsive design
- 🔌 REST API endpoints for programmatic access
- 🗄️ H2 in-memory database for development
- 🎨 Modern UI with Bootstrap 5
- 🔄 Hot reload for development
- 📊 H2 console for database management

## Tech Stack

- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Data JPA** - Data persistence
- **Thymeleaf** - Template engine
- **H2 Database** - In-memory database
- **Bootstrap 5** - CSS framework
- **Maven** - Build tool

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd just-blog
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Open your browser and navigate to:
   - Web interface: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

### H2 Database Configuration

When accessing the H2 console, use these settings:

- **JDBC URL**: `jdbc:h2:mem:blogdb`
- **Username**: `sa`
- **Password**: (leave empty)

## API Endpoints

### REST API

| Method | Endpoint                        | Description           |
| ------ | ------------------------------- | --------------------- |
| GET    | `/api/posts`                    | Get all blog posts    |
| GET    | `/api/posts/{id}`               | Get a specific post   |
| POST   | `/api/posts`                    | Create a new post     |
| PUT    | `/api/posts/{id}`               | Update a post         |
| DELETE | `/api/posts/{id}`               | Delete a post         |
| GET    | `/api/posts/search?title=query` | Search posts by title |
| GET    | `/api/posts/author/{author}`    | Get posts by author   |

### Web Interface

| Route        | Description              |
| ------------ | ------------------------ |
| `/`          | Home page with all posts |
| `/post/{id}` | View a specific post     |
| `/new`       | Create a new post        |
| `/edit/{id}` | Edit an existing post    |

## Sample API Usage

### Create a new post:

```bash
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My New Post",
    "content": "This is the content of my new post.",
    "author": "John Doe"
  }'
```

### Get all posts:

```bash
curl http://localhost:8080/api/posts
```

### Search posts by title:

```bash
curl "http://localhost:8080/api/posts/search?title=spring"
```

## Development

### Running Tests

```bash
mvn test
```

### Building for Production

```bash
mvn clean package
java -jar target/just-blog-1.0.0.jar
```

### Development Mode

The application includes Spring Boot DevTools for automatic restart during development. Simply save your changes and the application will restart automatically.

## Project Structure

```
src/
├── main/
│   ├── java/com/example/justblog/
│   │   ├── JustBlogApplication.java     # Main application class
│   │   ├── model/
│   │   │   └── BlogPost.java            # Blog post entity
│   │   ├── repository/
│   │   │   └── BlogPostRepository.java  # Data access layer
│   │   ├── service/
│   │   │   └── BlogPostService.java     # Business logic
│   │   ├── controller/
│   │   │   ├── BlogPostController.java  # REST API controller
│   │   │   └── WebController.java       # Web interface controller
│   │   └── config/
│   │       └── DataInitializer.java     # Sample data setup
│   └── resources/
│       ├── application.properties       # Configuration
│       └── templates/                   # Thymeleaf templates
│           ├── index.html
│           ├── post.html
│           ├── new-post.html
│           └── edit-post.html
└── test/
    └── java/com/example/justblog/
        └── JustBlogApplicationTests.java
```

## Configuration

The application can be configured through `application.properties`:

- `server.port` - Change the server port (default: 8080)
- `spring.datasource.*` - Database configuration
- `spring.jpa.*` - JPA/Hibernate settings
- `spring.h2.console.enabled` - Enable/disable H2 console

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Sample Data

The application comes with sample blog posts to help you get started. These are created automatically when the application starts and the database is empty.
