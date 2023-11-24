package IO;

import Statics.Finals;
import model.Book;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReader {
    public static Set<Book> readBooks() {
        Set<Book> allBooks = new HashSet<>();

        try(Scanner scanner = new Scanner(new FileReader(Finals.BOOKS_FILE))) {
            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                allBooks.add(new Book(data[0], data[1]));
            }
        } catch (Exception ignore) {}

        return allBooks;
    }

    public static Set<Book> readBooksFrom(String path) {
        Set<Book> allBooks = new HashSet<>();

        try(Scanner scanner = new Scanner(new FileReader(path))) {
            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                allBooks.add(new Book(data[0], data[1]));
            }
        } catch (Exception ignore) {}

        return allBooks;
    }

}
