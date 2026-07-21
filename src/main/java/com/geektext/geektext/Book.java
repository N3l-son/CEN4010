package com.geektext.geektext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_description", length = 1000)
    private String bookDescription;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "year_published")
    private int yearPublished;

    @Column(name = "copies_sold")
    private int copiesSold;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    // --- Constructors ---
    public Book() {
    }

    public Book(String isbn, String bookName, String bookDescription, double price, String genre, String publisher, int yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    // --- Getters and Setters ---
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getBookDescription() { return bookDescription; }
    public void setBookDescription(String bookDescription) { this.bookDescription = bookDescription; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    public int getCopiesSold() { return copiesSold; }
    public void setCopiesSold(int copiesSold) { this.copiesSold = copiesSold; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}