package com.browsing.book.book;


import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;
    private int copiesSold;
    private double rating;
    private String isbn;
    private String bookName;
    private String description;
    private String author;
    private String publisher;
    private int yearPublished;
    private double price;

    public Book(){

    }

    public Book(String genre, int copiesSold, double rating, String isbn, String bookName, String description, String author, String publisher, int yearPublished, double price) {
        this.genre = genre;
        this.copiesSold = copiesSold;
        this.rating = rating;
        this.isbn = isbn;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
