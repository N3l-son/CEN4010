package com.browsing.book.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")

public class BookController {
    @Autowired
    private BookRepository bookRepository; //doesnt use this
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBooks(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getBooksByGenre(@RequestParam(required = false) String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/top-sellers")
    public List<Book> getTopSellers(){
        return bookService.getTopSellers();
    }

    @GetMapping("/rating")
    public List<Book> getBooksByRating(@RequestParam double minRating){
        return bookService.getBooksByMinimumRating(minRating);
    }


}
