package Statics;

import model.Book;
import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class StaticMethods {
    private StaticMethods() {}

    public static void createDirectory(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }


    public static StringBuilder getBookStringData(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append(book.getName()).append(" ")
                .append(book.getAuthor());
        return sb;
    }

    public static StringBuilder getStringUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getName()).append(" ")
                .append(user.getBooksNamePath());
        return sb;
    }

    /**
     * @param uid is the uid of the user for whom the file need to be created
     * @return the file name of with extension
     */
    public static String getUserBooksFileName(String uid) {
        return Finals.USER_BOOKS+"/"+uid+".dat";
    }

}
