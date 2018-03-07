package p8_book_library;

import java.util.*;
import java.util.stream.Collectors;

public class BookLibrary {
    private String name;
    private List<Book> books;

    public BookLibrary() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void printBook() {

        Map<String, Double> result = this.books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors
                .summingDouble
                        (Book::getPrice)));

        result.entrySet().stream().sorted((a,b)-> {
            if (a.getValue().equals(b.getValue()))
                return a.getKey().compareTo(b.getKey());
            else
                return b.getValue().compareTo(a.getValue());
        }).forEach(kv -> System.out.printf("%s -> %.2f%n", kv.getKey(), kv.getValue()));
    }
}
