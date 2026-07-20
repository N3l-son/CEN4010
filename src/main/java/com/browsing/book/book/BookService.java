package com.browsing.book.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){ this.bookRepository = bookRepository;}


    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    public List<Book> getBooksByGenre(@RequestParam(required = false) String genre){
        if (genre == null){
            return bookRepository.findAll();
        }
        return bookRepository.findByGenre(genre);

    }

    public List<Book> getTopSellers(){
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getBooksByMinimumRating(double rating){
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
}
