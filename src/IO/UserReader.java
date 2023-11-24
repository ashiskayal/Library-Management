package IO;

import Statics.Finals;
import model.Book;
import model.User;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserReader {

    public static Set<User> readUsers() {
        Set<User> allUsers = new HashSet<>();

        try(Scanner scanner = new Scanner(new FileReader(Finals.USERS_FILE))) {
            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                allUsers.add(new User(data[0], data[1]));
            }
        } catch (Exception ignore) {}

        for(User u : allUsers) {
            u.addAllBooks(BookReader.readBooksFrom(u.getBooksNamePath()));
        }

        return allUsers;
    }

}
