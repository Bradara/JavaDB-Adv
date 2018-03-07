package p8_book_library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BookLibrary bl = new BookLibrary();

        while (n-->0){
            String[] input = br.readLine().split(" ");
            Book book = new Book(input[0], input[1], input[2], LocalDate.parse(input[3], dtf), input[4], Double
                    .parseDouble
                    (input[5]));
            bl.addBook(book);
        }

        bl.printBook();
    }
}
