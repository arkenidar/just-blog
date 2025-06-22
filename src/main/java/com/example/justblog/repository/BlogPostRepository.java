package com.example.justblog.repository;

import com.example.justblog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    
    @Query("SELECT b FROM BlogPost b ORDER BY b.createdAt DESC")
    List<BlogPost> findAllByOrderByCreatedAtDesc();
    
    List<BlogPost> findByTitleContainingIgnoreCase(String title);
    
    List<BlogPost> findByAuthorIgnoreCase(String author);
}
