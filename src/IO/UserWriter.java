package IO;

import Statics.Finals;
import Statics.StaticMethods;
import model.Book;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class UserWriter {

    public static void writeUsers(User... users) {
        StaticMethods.createDirectory(Path.of(Finals.USER_DIRECTORY_NAME));
        StaticMethods.createDirectory(Path.of(Finals.USER_BOOKS));

        try (FileWriter fileWriter = new FileWriter(Finals.USERS_FILE)) {
            for (User d : users) {
                fileWriter.write( StaticMethods.getStringUser(d) +"\n");
                writeUserBooks(d.getBooksNamePath() == null ?
                                StaticMethods.getUserBooksFileName(d.getName()): d.getBooksNamePath(),
                                d.getBooks().toArray(Book[]::new));
            }
        } catch (IOException e) {
            System.out.println("writeUsers -> FileWriter throws below exception.");
            e.printStackTrace();
        }
    }

    private static void writeUserBooks(String path, Book... books) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            for (Book b : books) {
                fileWriter.write( StaticMethods.getBookStringData(b) +"\n");
            }
        } catch (IOException e) {
            System.out.println("writeUserBooks -> FileWriter throws below exception.");
            e.printStackTrace();
        }
    }
}
