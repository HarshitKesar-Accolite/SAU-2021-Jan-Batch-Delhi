package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.repository.BlogRepository;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    //ADD NEW BLOG POST
    @PostMapping("/blogs") 
    public Blogs addBlogPost(@RequestBody Blogs newBlog) {
        return blogRepository.save(newBlog);
    }
    
    //FIND BLOG BY ID
    @GetMapping("/blogs/{id}")
    public Optional<Blogs> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    //GET ALL BLOGS BY AUTHOR NAME
    @GetMapping("/blogs/author/{author}")
    public List<Blogs> getBlogsByAuthorName(@PathVariable String author) {
    	List<Blogs> result = new ArrayList<>();
        for(Blogs blog : blogRepository.findAll()) {
        	if(blog.getAuthor().equals(author)) {
        		result.add(blog);
        	}
        }
        return result;
    }
    
    //DELETE BLOG BY ID
    @DeleteMapping("/blogs/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }
    
    //FIND ALL BLOGS BY TAG
    @GetMapping("/blogs/tags/{tag}")
    public List<Blogs> getBlogsByTag(@PathVariable String tag) {
        List<Blogs> result = new ArrayList<>();
        for(Blogs blog : blogRepository.findAll()) {
        	if(blog.getTags().contains(tag)) {
        		result.add(blog);
        	}
        }
        return result;
    }
}