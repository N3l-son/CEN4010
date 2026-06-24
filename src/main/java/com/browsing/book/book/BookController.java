package com.browsing.book.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")

public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book createBooks(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String genre){
        if(genre == null){
            return bookRepository.findAll();
        }
        return bookRepository.findByGenre(genre);
    }

}
