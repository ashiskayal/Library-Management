package IO;

import Statics.Finals;
import Statics.StaticMethods;
import model.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class BookWriter {
    public static void writeBooks(Book... books) {
        StaticMethods.createDirectory(Path.of(Finals.BOOK_DIRECTORY_NAME));
        try (FileWriter fileWriter = new FileWriter(Finals.BOOKS_FILE)) {
            for (Book b : books) {
                fileWriter.write( StaticMethods.getBookStringData(b) +"\n");
            }
        } catch (IOException e) {
            System.out.println("writeBooks -> FileWriter throws below exception.");
            e.printStackTrace();
        }
    }
}
