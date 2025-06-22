package com.example.justblog.controller;

import com.example.justblog.model.BlogPost;
import com.example.justblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    
    private final BlogPostService blogPostService;
    
    @Autowired
    public WebController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", blogPostService.getAllPosts());
        return "index";
    }
    
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        return blogPostService.getPostById(id)
                .map(post -> {
                    model.addAttribute("post", post);
                    return "post";
                })
                .orElse("redirect:/");
    }
    
    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new BlogPost());
        return "new-post";
    }
    
    @PostMapping("/new")
    public String createPost(@ModelAttribute BlogPost blogPost) {
        blogPostService.createPost(blogPost);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        return blogPostService.getPostById(id)
                .map(post -> {
                    model.addAttribute("post", post);
                    return "edit-post";
                })
                .orElse("redirect:/");
    }
    
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute BlogPost blogPost) {
        blogPostService.updatePost(id, blogPost);
        return "redirect:/post/" + id;
    }
    
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return "redirect:/";
    }
}
