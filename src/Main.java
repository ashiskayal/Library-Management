import IO.BookReader;
import IO.BookWriter;
import IO.UserReader;
import IO.UserWriter;
import Statics.Finals;
import model.Book;
import model.User;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Set<Book> allBooks = new HashSet<>();
    private static Set<User> allUsers = new HashSet<>();

    private static Scanner sc;

    public static void main(String[] args) {
        /*
        Set<User> users = new HashSet<>();
        Set<Book> books = new HashSet<>();
        for(int i = 0; i<10; i++) {
            User u = new User("UserName"+i);
            Book b = new Book("BookName"+i, "AuthorName"+i);
            u.addBook(b);
            users.add(u);
            books.add(b);
        }

        UserWriter.writeUsers(users.toArray(User[]::new));
        BookWriter.writeBooks(books.toArray(Book[]::new));
*/

        loadData();

        sc = new Scanner(System.in);
        String chosenOption;

        do {
            System.out.println(Finals.MAIN_MENU);
            chosenOption = sc.next();
            switch (chosenOption) {
                case "1" : // Add Book
                    allBooks.add(addBook());
                    break;
                case "2": // Add User
                    allUsers.add(addUser());
                    break;
                case "3": // Return Book
                    returnBook();
                    break;
                case "4" : // BorrowBook
                    borrowBook();
                    break;
                case "5": // Display all books
                    displayAllBooks();
                    break;
                case "6": // Display all users
                    displayAllUsers();
                    break;
                case "7": break; // Exit
                default:
                    System.out.println("Choose right option");
            }
        } while (!chosenOption.equals("7"));

        UserWriter.writeUsers(allUsers.toArray(User[]::new));
        BookWriter.writeBooks(allBooks.toArray(Book[]::new));

    }

    private static Book addBook() {
        String name;
        do {
            System.out.println("Enter Book name: ");
            name = sc.next();
        } while (name == null || name.trim().isEmpty());

        String authName;
        do {
            System.out.println("Enter Author's name: ");
            authName = sc.next();
        } while (authName == null || authName.trim().isEmpty());

        return new Book(name.trim(), authName.trim());
    }

    private static User addUser() {
        String name;
        do {
            System.out.println("Enter User name: ");
            name = sc.next();
        } while (name == null || name.trim().isEmpty());

        return new User(name);
    }

    private static void returnBook() {
        User enteredUser = userInputImplementation();
        if(enteredUser == null) return;

        Book enteredBook = bookInputImplementation();
        if (enteredBook == null) return;

        enteredUser.removeBook(enteredBook);
        updateUserData(enteredUser);
    }

    private static void borrowBook() {
        User enteredUser = userInputImplementation();
        if(enteredUser == null) return;

        Book enteredBook = bookInputImplementation();
        if(enteredBook == null) return;

        enteredUser.addBook(enteredBook);
        updateUserData(enteredUser);
    }

    private static User searchUser(String name) {
        if(name == null || name.trim().isEmpty()) return null;
        name = name.trim();
        for (User u : allUsers) {
            if (u.getName().equals(name)) return u;
        }
        return null;
    }

    private static Book searchBook(Book book) {
        if(book.getName().isEmpty() || book.getAuthor().isEmpty()) return null;
        for (Book b : allBooks) {
            if(b.equals(book)) return b;
        }
        return null;
    }

    private static void displayAllBooks() {
        if(allBooks.isEmpty())  {
            System.out.println("No books available, try to add some.");
            return;
        }
        for (Book b : allBooks) System.out.println(b);
    }

    private static void displayAllUsers() {
        if(allBooks.isEmpty()) {
            System.out.println("No users available, try to add some.");
            return;
        }
        for (User u : allUsers) System.out.println(u);
     }

     private static void updateUserData(User user) {
        for (User u : allUsers) {
            if(u.equals(user))
                u.addAllBooks(user.getBooks());
        }
     }

     private static User userInputImplementation() {
         String name;
         do {
             System.out.println("Enter User name: ");
             name = sc.next();
         } while (name == null || name.trim().isEmpty());

         User enteredUser = searchUser(name);
         if(enteredUser == null) {
             System.out.println("User of name : \""+name+"\" not found.");
             return null;
         }
         return enteredUser;
     }

     private static Book bookInputImplementation() {
         String bookName;
         do {
             System.out.println("Enter Book name: ");
             bookName = sc.next();
         } while (bookName == null || bookName.trim().isEmpty());

         String bookAuthor;
         do {
             System.out.println("Enter Book author name: ");
             bookAuthor = sc.next();
         } while (bookAuthor == null || bookAuthor.trim().isEmpty());


         Book enteredBook = searchBook(new Book(bookName, bookAuthor));
         if(enteredBook == null) {
             System.out.println("No book found");
             return null;
         }
         return enteredBook;
     }


     private static void loadData() {
         allUsers = UserReader.readUsers();
         allBooks = BookReader.readBooks();
     }


}