package com.geektext.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors") 
public class AuthorController {

    // This tells Spring Boot to automatically inject the repository you just made
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public void createAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }
}