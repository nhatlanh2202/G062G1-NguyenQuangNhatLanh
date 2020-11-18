package com.codegym.controller;


import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Blog>> getListBlog(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getStudent(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        this.blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/studentRest/detail/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
