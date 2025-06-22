package com.example.justblog.config;

import com.example.justblog.model.BlogPost;
import com.example.justblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final BlogPostRepository blogPostRepository;
    
    @Autowired
    public DataInitializer(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Add some sample blog posts
        if (blogPostRepository.count() == 0) {
            BlogPost post1 = new BlogPost(
                "Welcome to Just Blog!",
                "This is the first post on our new blog application built with Spring Boot. " +
                "Here you can create, read, update, and delete blog posts with ease.\n\n" +
                "Features include:\n" +
                "- Clean and modern UI with Bootstrap\n" +
                "- REST API endpoints\n" +
                "- H2 in-memory database\n" +
                "- Thymeleaf templating\n" +
                "- Responsive design\n\n" +
                "Feel free to create your own posts and explore the application!",
                "Admin"
            );
            
            BlogPost post2 = new BlogPost(
                "Getting Started with Spring Boot",
                "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications. " +
                "In this blog application, we're using several Spring Boot starters:\n\n" +
                "- spring-boot-starter-web: For web applications\n" +
                "- spring-boot-starter-data-jpa: For database access\n" +
                "- spring-boot-starter-thymeleaf: For templating\n" +
                "- spring-boot-devtools: For development convenience\n\n" +
                "The application follows the MVC pattern with proper separation of concerns.",
                "Spring Developer"
            );
            
            BlogPost post3 = new BlogPost(
                "RESTful API Design",
                "This blog application exposes a RESTful API that you can use to interact with blog posts programmatically.\n\n" +
                "Available endpoints:\n" +
                "- GET /api/posts - Get all posts\n" +
                "- GET /api/posts/{id} - Get a specific post\n" +
                "- POST /api/posts - Create a new post\n" +
                "- PUT /api/posts/{id} - Update a post\n" +
                "- DELETE /api/posts/{id} - Delete a post\n" +
                "- GET /api/posts/search?title=query - Search posts by title\n" +
                "- GET /api/posts/author/{author} - Get posts by author\n\n" +
                "All endpoints return JSON responses and follow REST conventions.",
                "API Designer"
            );
            
            blogPostRepository.save(post1);
            blogPostRepository.save(post2);
            blogPostRepository.save(post3);
        }
    }
}
