package p8_book_library;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate release_date;
    private String ISBN_number;
    private double price;

    public Book(String title, String author, String publisher, LocalDate release_date, String ISBN_number, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.release_date = release_date;
        this.ISBN_number = ISBN_number;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
