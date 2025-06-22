package com.example.justblog.config;

import com.example.justblog.model.BlogPost;
import com.example.justblog.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final BlogPostRepository blogPostRepository;
    
    public DataInitializer(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Add some sample blog posts
        if (blogPostRepository.count() == 0) {
            BlogPost post1 = new BlogPost(
                "Welcome to Just Blog!",
                """
                This is the first post on our new blog application built with Spring Boot. \
                Here you can create, read, update, and delete blog posts with ease.
                
                Features include:
                - Clean and modern UI with Bootstrap
                - REST API endpoints
                - H2 in-memory database
                - Thymeleaf templating
                - Responsive design
                
                Feel free to create your own posts and explore the application!""",
                "Admin"
            );
            
            BlogPost post2 = new BlogPost(
                "Getting Started with Spring Boot",
                """
                Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications. \
                In this blog application, we're using several Spring Boot starters:
                
                - spring-boot-starter-web: For web applications
                - spring-boot-starter-data-jpa: For database access
                - spring-boot-starter-thymeleaf: For templating
                - spring-boot-devtools: For development convenience
                
                The application follows the MVC pattern with proper separation of concerns.""",
                "Spring Developer"
            );
            
            BlogPost post3 = new BlogPost(
                "RESTful API Design",
                """
                This blog application exposes a RESTful API that you can use to interact with blog posts programmatically.
                
                Available endpoints:
                - GET /api/posts - Get all posts
                - GET /api/posts/{id} - Get a specific post
                - POST /api/posts - Create a new post
                - PUT /api/posts/{id} - Update a post
                - DELETE /api/posts/{id} - Delete a post
                - GET /api/posts/search?title=query - Search posts by title
                - GET /api/posts/author/{author} - Get posts by author
                
                All endpoints return JSON responses and follow REST conventions.""",
                "API Designer"
            );
            
            blogPostRepository.save(post1);
            blogPostRepository.save(post2);
            blogPostRepository.save(post3);
        }
    }
}
