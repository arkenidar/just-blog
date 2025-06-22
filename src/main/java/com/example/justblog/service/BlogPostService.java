package com.example.justblog.service;

import com.example.justblog.model.BlogPost;
import com.example.justblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    
    private final BlogPostRepository blogPostRepository;
    
    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    
    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public Optional<BlogPost> getPostById(Long id) {
        return blogPostRepository.findById(id);
    }
    
    public BlogPost createPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
    
    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        return blogPostRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthor(updatedPost.getAuthor());
                    return blogPostRepository.save(post);
                })
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }
    
    public void deletePost(Long id) {
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
        } else {
            throw new RuntimeException("Post not found with id: " + id);
        }
    }
    
    public List<BlogPost> searchPostsByTitle(String title) {
        return blogPostRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<BlogPost> getPostsByAuthor(String author) {
        return blogPostRepository.findByAuthorIgnoreCase(author);
    }
}
